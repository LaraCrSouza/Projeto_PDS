package main;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastrarProdutoController;
import controller.CadastroController;
import controller.ComprasController;
import controller.LoginController;
import controller.Navegador;
import controller.VisualizarTabelaController;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.Janela;
import view.TelaCadastrarProduto;
import view.TelaCadastroUsuario;
import view.TelaCompras;
import view.TelaLogin;
import view.TelaVisualizarTabela;

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
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		//View
		TelaLogin telaLogin= new TelaLogin();
		TelaCadastroUsuario telaCadastroU = new TelaCadastroUsuario();
		TelaCadastrarProduto  telaCadastrarP= new TelaCadastrarProduto();
		TelaCompras telaCompras = new TelaCompras();
		TelaVisualizarTabela telaVisualizarTabela = new TelaVisualizarTabela();
		
		Navegador navegador = new Navegador(janela, telaLogin);
		CadastroController cadastroControllerU = new CadastroController(telaCadastroU, usuarioDAO, navegador);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		CadastrarProdutoController produtoController = new CadastrarProdutoController(telaCadastrarP, produtoDAO, navegador);
		VisualizarTabelaController visualizarController = new VisualizarTabelaController(telaVisualizarTabela, produtoDAO, navegador);
		ComprasController compras = new ComprasController(telaCompras, produtoDAO);
		
		
		

		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastroU);
		navegador.adicionarPainel("CADASTRO PRODUTO", telaCadastrarP);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("VISUALIZAR TABELA", telaVisualizarTabela);
		navegador.adicionarPainel("COMPRAS", telaCompras);

		//Seta o jframe para abrir no meio da tela.
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
	}
}
