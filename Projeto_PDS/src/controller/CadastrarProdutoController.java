//package controller;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseAdapter;
//import java.util.List;
//
//import javax.swing.JOptionPane;
//import model.Produto;
//import model.ProdutoDAO;
//import view.TelaCadastrarProduto;
//import view.TelaVisualizarProdutos;
//
//public class CadastrarProdutoController {
//	
//	private TelaCadastrarProduto cadastro;
//	private ProdutoDAO produto;
//	private Navegador navegador;
//
//	public CadastrarProdutoController(TelaCadastrarProduto cadastro, ProdutoDAO produto, Navegador navegador) {
//		super();
//		this.cadastro = cadastro;
//		this.produto = produto;
//		this.navegador = navegador;
//		
//		this.cadastro.cadastrar(e -> {
//			verificarCadastroUsuario();
//		});
//		
//		this.cadastro.irParaTabela(new MouseAdapter() {
//			 @Override
//			    public void mouseClicked(MouseEvent e) {
//			        navegador.navegarPara("VISUALIZAR PRODUTOS");
//			 }
//			 
//		});
//		
//	}
//	
//
//	private void verificarCadastroUsuario() {
//		List<Produto> produto = produto.listarProduto();
//		
//		if(cadastro.gettfNome().getText().isEmpty() || cadastro.gettfCodigo().getText().isEmpty() 
//		|| cadastro.gettfURL().getText().isEmpty() || cadastro.gettfPesoBruto.getText().isEmpty() 
//		|| cadastro.gettfAltura().getText().isEmpty() || cadastro.gettfLargura().getText().isEmpty() 
//		|| cadastro.gettfComprimento().getText().isEmpty() || cadastro.gettfPreco().getText().isEmpty() ) {
//			
//			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
//		}
//		
//	}
//	
//	public void limparCamposLogin() {
//		cadastro.gettfEmailC().setText("");
//		cadastro.gettfNomeC().setText("");
//	}
//	
//	
//
//}
