package controller;

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
	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuario = user.listarUsuarios();
		
		if(cadastro.gettfNomeC().getText().isEmpty() || cadastro.gettfEmailC().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
		}
		else {
			boolean usuarioEncontrado = false;
			
			for(Usuario user : usuario) {
				
				if(user.getNome().equals(cadastro.gettfNomeC().getText()) && user.getEmail().equals(cadastro.gettfEmailC().getText())){
					
					usuarioEncontrado = true;
					break;
				};
			}
		
			if(usuarioEncontrado) {
				this.navegador.navegarPara("VISUALIZAR PRODUTOS");
			}
			else {
				JOptionPane.showConfirmDialog(null, "Usuário não encontrado");
			}
		}
		
	}
	
	public void limparCamposLogin() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfNomeC().setText("");
	}
	

}
