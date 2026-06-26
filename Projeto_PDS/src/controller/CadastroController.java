package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuario;
import view.TelaLogin;

public class CadastroController {

	private TelaCadastroUsuario cadastro;
	private UsuarioDAO user;
	private Navegador navegador;

	public CadastroController(TelaCadastroUsuario cadastro, UsuarioDAO user, Navegador navegador) {
		super();
		this.cadastro = cadastro;
		this.user = user;
		this.navegador = navegador;

		this.cadastro.cadastrar(e -> {
			verificarCadastroUsuario();
		});

		this.cadastro.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarPara("LOGIN");
				limparCamposCadastro();
			}

		});
	}

	private void verificarCadastroUsuario() {

		String nome = cadastro.gettfNomeC().getText();
		String email = cadastro.gettfEmailC().getText();

		if (nome.isEmpty() || email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha todos os campos", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (!email.contains("@") || email.substring(0, email.indexOf("@")).contains(" ")) {
			JOptionPane.showMessageDialog(null, "Por favor, insira um e-mail válido", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			for (Usuario u : user.listarUsuarios()) {
				if (u.getEmail().equals(email)) {
					JOptionPane.showMessageDialog(null, "Este e-mail já está cadastrado no sistema.",
							"E-mail Duplicado", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

			Usuario novoUsuario = new Usuario();
			novoUsuario.setNome(nome);
			novoUsuario.setEmail(email);
			Object tipo = cadastro.getcbTipoUsuario().getSelectedItem();
			if (tipo == null) {
				JOptionPane.showMessageDialog(null, "Selecione um tipo de usuário", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			novoUsuario.settipoUsuario(tipo.toString());

			user.adicionarUsuario(novoUsuario);
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
			navegador.navegarPara("LOGIN");
			limparCamposCadastro();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário no banco de dados. Tente novamente.",
					"Erro de Conexão", JOptionPane.ERROR_MESSAGE);
		}
	}



	public void limparCamposCadastro() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfNomeC().setText("");
	}
}
