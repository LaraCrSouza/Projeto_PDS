package main;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastrarProdutoController;
import controller.CadastroController;
import controller.CarrinhoController;
import controller.ComprasController;
import controller.FinalizarCompraController;
import controller.LoginController;
import controller.Navegador;
import controller.VisualizarProdutoController;
import controller.VisualizarTabelaController;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.Janela;
import view.NotaFiscal;
import view.TelaCadastrarProduto;
import view.TelaCadastroUsuario;
import view.TelaCarrinho;
import view.TelaCompras;
import view.TelaFinalizarCompra;
import view.TelaLogin;
import view.TelaVisualizarProduto;
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
		java.util.List<model.Produto> listaCarrinho = new java.util.ArrayList<>();
		
		//View
		TelaLogin telaLogin= new TelaLogin();
		TelaCadastroUsuario telaCadastroU = new TelaCadastroUsuario();
		TelaCadastrarProduto  telaCadastrarP= new TelaCadastrarProduto();
		TelaCompras telaCompras = new TelaCompras();
		TelaVisualizarTabela telaVisualizarTabela = new TelaVisualizarTabela();
		TelaCarrinho telaCarrinho = new TelaCarrinho();
		TelaFinalizarCompra finalizarCompra = new TelaFinalizarCompra();
		NotaFiscal notaFiscal = new NotaFiscal();
		TelaVisualizarProduto telaVisualizarProduto = new TelaVisualizarProduto();
		
		Navegador navegador = new Navegador(janela, telaLogin);
		navegador.setTelaCarrinho(telaCarrinho);
		navegador.setTelaVisualizarProduto(telaVisualizarProduto);
		CadastroController cadastroControllerU = new CadastroController(telaCadastroU, usuarioDAO, navegador);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		VisualizarTabelaController visualizarController = new VisualizarTabelaController(telaVisualizarTabela, produtoDAO, navegador);
		CadastrarProdutoController produtoController = new CadastrarProdutoController(telaCadastrarP, produtoDAO, navegador, visualizarController);
		ComprasController compras = new ComprasController(telaCompras, produtoDAO, navegador, listaCarrinho, finalizarCompra);
		CarrinhoController carrinhoController = new CarrinhoController(telaCarrinho, listaCarrinho, navegador);
		FinalizarCompraController finalizar = new FinalizarCompraController (finalizarCompra, navegador, listaCarrinho, notaFiscal);
		VisualizarProdutoController visualizarProduto = new VisualizarProdutoController(telaVisualizarProduto, navegador);
		
		

		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastroU);
		navegador.adicionarPainel("CADASTRO PRODUTO", telaCadastrarP);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("VISUALIZAR TABELA", telaVisualizarTabela);
		navegador.adicionarPainel("COMPRAS", telaCompras);
		navegador.adicionarPainel("CARRINHO", telaCarrinho);
		navegador.adicionarPainel("FINALIZAR COMPRA", finalizarCompra);
		navegador.adicionarPainel("NOTA FISCAL", notaFiscal);
		navegador.adicionarPainel("VISUALIZAR PRODUTO", telaVisualizarProduto);

		//Seta o jframe para abrir no meio da tela.
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
	}
}
