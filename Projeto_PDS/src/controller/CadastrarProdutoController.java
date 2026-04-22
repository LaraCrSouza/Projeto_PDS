package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JOptionPane;
import model.Produto;
import model.ProdutoDAO;
import view.TelaCadastrarProduto;
import view.TelaVisualizarTabela;

public class CadastrarProdutoController {
	
	private TelaCadastrarProduto cadastro;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private VisualizarTabelaController visualizarController;

	public CadastrarProdutoController(TelaCadastrarProduto cadastro, ProdutoDAO produtoDAO, Navegador navegador, VisualizarTabelaController visualizarController) {
		super();
		this.cadastro = cadastro;
		this.produtoDAO = produtoDAO;
		this.navegador = navegador;
		this.visualizarController = visualizarController;
		
		this.cadastro.cadastrar(e -> {
			CadastroProduto();
		});
		
		this.cadastro.irParaTabela(new MouseAdapter() {
			 @Override
			    public void mouseClicked(MouseEvent e) {
			        navegador.navegarPara("VISUALIZAR TABELA");
			        limparCampos();
			 }
			 
		});
		this.cadastro.sair(new MouseAdapter() {
			 @Override
			    public void mouseClicked(MouseEvent e) {
			        navegador.navegarPara("LOGIN");
			 }
			 
		});
		
	}
	

	private void CadastroProduto() {
		
		if(cadastro.gettfNome().getText().isEmpty() || cadastro.gettfCodigo().getText().isEmpty() 
		|| cadastro.gettfURL().getText().isEmpty() || cadastro.gettfPesoBruto().getText().isEmpty() 
		|| cadastro.gettfAltura().getText().isEmpty() || cadastro.gettfLargura().getText().isEmpty() 
		|| cadastro.gettfComprimento().getText().isEmpty() || cadastro.gettfPreco().getText().isEmpty() 
		|| cadastro.gettfMarca().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
			limparCampos();
			return;
		}
		
		Object categoria = cadastro.getcbCategorias().getSelectedItem();

		if (categoria == null) {
		    JOptionPane.showMessageDialog(null, "Selecione uma categoria");
		    return;
		}
		
		 Produto produto = new Produto();

		    produto.setNome(cadastro.gettfNome().getText());
		    produto.setCodigo(Integer.parseInt(cadastro.gettfCodigo().getText()));
		    produto.setURL(cadastro.gettfURL().getText());
		    produto.setMarca(cadastro.gettfMarca().getText());
		    produto.setCategorias(cadastro.getcbCategorias().getSelectedItem().toString());
		    produto.setPesoBruto(Float.parseFloat(cadastro.gettfPesoBruto().getText()));
		    produto.setAltura(Float.parseFloat(cadastro.gettfAltura().getText()));
		    produto.setLargura(Float.parseFloat(cadastro.gettfLargura().getText()));
		    produto.setComprimento(Float.parseFloat(cadastro.gettfComprimento().getText()));
		    produto.setPreco(Double.parseDouble(cadastro.gettfPreco().getText()));
		    
		    produtoDAO.adicionarProduto(produto);
		    limparCampos();

		    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		    
		
	}

	public void limparCampos() {
		cadastro.gettfAltura().setText("");
		cadastro.gettfCodigo().setText("");
		cadastro.gettfComprimento().setText("");
		cadastro.gettfLargura().setText("");
		cadastro.gettfMarca().setText("");
		cadastro.gettfNome().setText("");
		cadastro.gettfPesoBruto().setText("");
		cadastro.gettfPreco().setText("");
		cadastro.gettfURL().setText("");
	}

}
