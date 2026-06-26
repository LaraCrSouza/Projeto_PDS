package main;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastrarProdutoController;
import controller.CadastroController;
import controller.CarrinhoController;
import controller.ComprasController;
import controller.EditarProdutoController;
import controller.FinalizarCompraController;
import controller.LoginController;
import controller.Navegador;
import controller.VisualizarProdutoController;
import controller.VisualizarTabelaController;import model.CarrinhoDAO;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.EditarProduto;
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
import model.CarrinhoDAO;

/**
 * Classe responsável por inicializar os elementos das 3 camadas: model, view e
 * controller. A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) {
		
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 18)));

		Janela janela = new Janela();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		java.util.List<model.Produto> listaCarrinho = new java.util.ArrayList<>();

		// View
		TelaLogin telaLogin = new TelaLogin();
		TelaCadastroUsuario telaCadastroU = new TelaCadastroUsuario();
		TelaCadastrarProduto telaCadastrarP = new TelaCadastrarProduto();
		TelaCompras telaCompras = new TelaCompras();
		TelaVisualizarTabela telaVisualizarTabela = new TelaVisualizarTabela();
		TelaCarrinho telaCarrinho = new TelaCarrinho();
		
		NotaFiscal notaFiscal = new NotaFiscal();
		TelaVisualizarProduto telaVisualizarProduto = new TelaVisualizarProduto();
		EditarProduto editar = new EditarProduto();

		Navegador navegador = new Navegador(janela, telaLogin);
		navegador.setTelaCarrinho(telaCarrinho);
		navegador.setTelaVisualizarProduto(telaVisualizarProduto);
		navegador.setTelaCompras(telaCompras);
		
		TelaFinalizarCompra finalizarCompra = new TelaFinalizarCompra();
		navegador.setFinalizar(finalizarCompra);
		
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO(navegador);
		
		CadastroController cadastroControllerU = new CadastroController(telaCadastroU, usuarioDAO, navegador);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, carrinhoDAO, produtoDAO, listaCarrinho);
		EditarProdutoController editarProdutoController = new EditarProdutoController(editar, listaCarrinho, produtoDAO, navegador, null);
		VisualizarTabelaController visualizarController = new VisualizarTabelaController(telaVisualizarTabela,
				listaCarrinho, produtoDAO, navegador, editarProdutoController);
		ComprasController comprasController = new ComprasController(telaCompras, produtoDAO, navegador, listaCarrinho,
				finalizarCompra, carrinhoDAO);
		CadastrarProdutoController produtoController = new CadastrarProdutoController(telaCadastrarP, produtoDAO,
				navegador, visualizarController, telaVisualizarTabela, comprasController);
		CarrinhoController carrinhoController = new CarrinhoController(telaCarrinho, listaCarrinho, navegador, carrinhoDAO);
		navegador.setCarrinhoController(carrinhoController);
		FinalizarCompraController finalizar = new FinalizarCompraController(finalizarCompra, navegador, listaCarrinho,
				notaFiscal, carrinhoController, carrinhoDAO);
		VisualizarProdutoController visualizarProduto = new VisualizarProdutoController(telaVisualizarProduto,
				navegador);
	
		telaVisualizarTabela.adicionarOuvinte(visualizarController);

		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastroU);
		navegador.adicionarPainel("CADASTRO PRODUTO", telaCadastrarP);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("VISUALIZAR TABELA", telaVisualizarTabela);
		navegador.adicionarPainel("COMPRAS", telaCompras);
		navegador.adicionarPainel("CARRINHO", telaCarrinho);
		navegador.adicionarPainel("FINALIZAR COMPRA", finalizarCompra);
		navegador.adicionarPainel("VISUALIZAR PRODUTO", telaVisualizarProduto);
		navegador.adicionarPainel("EDITAR PRODUTO", editar);

		// Seta o jframe para abrir no meio da tela.
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
	}
}
