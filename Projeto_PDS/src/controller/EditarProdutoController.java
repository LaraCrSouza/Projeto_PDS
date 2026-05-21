package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.EditarProduto;
import view.TelaCadastroUsuario;
import view.TelaVisualizarTabela;

public class EditarProdutoController  extends ComponentAdapter{

	private EditarProduto editarProduto;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private List<Produto> visualizarTabela;
	
	public EditarProdutoController(EditarProduto editarProduto, List<Produto> visualizarTabela, ProdutoDAO produtoDAO,
			Navegador navegador) {
		super();
		this.editarProduto = editarProduto;
		this.produtoDAO = produtoDAO;
		this.visualizarTabela =  visualizarTabela;

		this.editarProduto.atualizar(e -> {
			atualizarProduto();
		});

		this.editarProduto.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarPara("VISUALIZAR TABELA");
			}

		});

	}

	public void componentShown(ComponentEvent e) {
	    editarProduto.atualizarTabela(); 
	}

	private void atualizarProduto() {

	    Produto produto = new Produto();

		produto.setNome(editarProduto.gettfNome().getText());
		produto.setCodigo(Integer.parseInt(editarProduto.gettfCodigo().getText()));
		produto.setURL(editarProduto.gettfURL().getText());
		produto.setMarca(editarProduto.gettfMarca().getText());
		produto.setCategorias(editarProduto.getcbCategorias().getSelectedItem().toString());
		produto.setPesoBruto(Float.parseFloat(editarProduto.gettfPesoBruto().getText()));
		produto.setAltura(Float.parseFloat(editarProduto.gettfAltura().getText()));
		produto.setLargura(Float.parseFloat(editarProduto.gettfLargura().getText()));
		produto.setComprimento(Float.parseFloat(editarProduto.gettfComprimento().getText()));
		produto.setPreco(Double.parseDouble(editarProduto.gettfPreco().getText()));

		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

	}

}
