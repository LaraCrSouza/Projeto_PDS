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
			limparCamposLogin();
		});
		this.login.cadastrarse(e -> {
			navegador.navegarPara("CADASTRO USUARIO");
			limparCamposLogin();
		});
	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuario = user.listarUsuarios();
		
		if(login.gettfNomeL().getText().isEmpty() || login.gettfEmailL().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
		}
		else {
			boolean usuarioEncontrado = false;
			String tipoUsuario = "";
			
			for(Usuario user : usuario) {
				
				if(user.gettipoUsuario().equals("Administrador") && user.getNome().equals(login.gettfNomeL().getText()) && user.getEmail().equals(login.gettfEmailL().getText())){
					
					usuarioEncontrado = true;
					tipoUsuario = "Administrador";
					break;
				}else if(user.gettipoUsuario().equals("Cliente") && user.getNome().equals(login.gettfNomeL().getText()) && user.getEmail().equals(login.gettfEmailL().getText())) {
					usuarioEncontrado = true;
					tipoUsuario = "Cliente";
					break;
				}
			}
			if(usuarioEncontrado == true) {
				if(tipoUsuario.equals("Administrador")){
					navegador.navegarPara("CADASTRO PRODUTO");
				} else if(tipoUsuario.equals("Cliente")) {
					navegador.navegarPara("COMPRAS");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
		}
		
	}
	
	public void limparCamposLogin() {
		login.gettfEmailL().setText("");
		login.gettfNomeL().setText("");
	}
}
