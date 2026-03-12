package main;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.Navegador;
import model.UsuarioDAO;
import view.Janela;
import view.TelaCadastrarProduto;
import view.TelaCadastroUsuario;
import view.TelaLogin;

/**
 * Classe responsável por inicializar os elementos das 3 camadas: model, view e controller.
 * A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) {
		//Altera a fonte dos JOptionPane para Arial, 18.
		UIManager.put("OptionPane.messageFont", new FontUIResource(
				new Font("Arial", Font.PLAIN, 18)
				));

		Janela janela = new Janela();
		Navegador navegador = new Navegador(janela);
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		TelaCadastroUsuario telaCadastroU = new TelaCadastroUsuario();
//		CadastroController cadastroController = new CadastroController(telaCadastro, candidatoDAO, navegador);

		TelaCadastrarProduto  telaCadastrarP= new TelaCadastrarProduto();
//		ContratacaoController contratacaoController = new ContratacaoController(telaContratacao, candidatoDAO, navegador);
//		telaContratacao.adicionarOuvinte(contratacaoController);

		TelaLogin telaLogin= new TelaLogin();
//		CentralController centralController = new CentralController(telaCentral, candidatoDAO, navegador);
//		telaCentral.adicionarOuvinte(centralController);

		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastroU);
		navegador.adicionarPainel("CADASTRO PRODUTO", telaCadastrarP);
		navegador.adicionarPainel("LOGIN", telaLogin);

		//Seta o jframe para abrir no meio da tela.
//		janela.setLocationRelativeTo(null);
//		janela.setVisible(true);

		navegador.navegarPara("CADASTRO");
	}
}
