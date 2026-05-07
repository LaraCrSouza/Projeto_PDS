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
			limparCamposCadastro();
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

		if (cadastro.gettfNomeC().getText().isEmpty() || cadastro.gettfEmailC().getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Prencha todos os campos", "Informação", 1);

		} else {

			Usuario novoUsuario = new Usuario();
			novoUsuario.setNome(cadastro.gettfNomeC().getText());
			novoUsuario.setEmail(cadastro.gettfEmailC().getText());
			novoUsuario.settipoUsuario(cadastro.getcbTipoUsuario().getSelectedItem().toString());

			user.adicionarUsuario(novoUsuario);

			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

			navegador.navegarPara("LOGIN");
			limparCamposLogin();

		}

	}

	public void limparCamposLogin() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfNomeC().setText("");
	}

	public void limparCamposCadastro() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfNomeC().setText("");
	}
}
