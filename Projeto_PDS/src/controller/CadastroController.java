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
		    }
			
		});
	}
	

	private void verificarCadastroUsuario() {
		List<Usuario> usuario = user.listarUsuarios();
		
		if(cadastro.gettfNomeC().getText().isEmpty() || cadastro.gettfEmailC().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
		}
		
	}
	
	public void limparCamposLogin() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfNomeC().setText("");
	}
	
	

}
