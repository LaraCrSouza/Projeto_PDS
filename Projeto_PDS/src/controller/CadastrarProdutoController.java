package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JOptionPane;
import model.Produto;
import model.ProdutoDAO;
import view.TelaCadastrarProduto;
import view.TelaVisualizarProdutos;

public class CadastrarProdutoController {
	
	private TelaCadastrarProduto cadastro;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;

	public CadastrarProdutoController(TelaCadastrarProduto cadastro, ProdutoDAO produtoDAO, Navegador navegador) {
		super();
		this.cadastro = cadastro;
		this.produtoDAO = produtoDAO;
		this.navegador = navegador;
		
		this.cadastro.cadastrar(e -> {
			CadastroProduto();
		});
		
		this.cadastro.irParaTabela(new MouseAdapter() {
			 @Override
			    public void mouseClicked(MouseEvent e) {
			        navegador.navegarPara("VISUALIZAR PRODUTOS");
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

		    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		
	}
	
	
	

}
