package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaLogin;

public class LoginController {
	
	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	
	public LoginController(TelaLogin login, UsuarioDAO user, Navegador navegador) {
		super();
		this.login = login;
		this.user = user;
		this.navegador = navegador;
		
		this.login.logar(e -> {
			verificarCadastroUsuario();
		});
	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuario = user.listarUsuarios();
		
		if(login.gettfNomeL().getText().isEmpty() || login.gettfEmailL().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
		}
		else {
			boolean usuarioEncontrado = false;
			
			for(Usuario user : usuario) {
				
			}
		}
		
	}
	

}
