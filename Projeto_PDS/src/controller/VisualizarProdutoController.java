package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuario;
import view.TelaVisualizarProdutos;

public class VisualizarProdutoController {
	
	private TelaVisualizarProdutos telaVisualizarProdutos;
	private ProdutoDAO produtoDAO;

	public  VisualizarProdutoController(TelaVisualizarProdutos telaVisualizarProdutos, ProdutoDAO produtoDAO) {
		super();
		this.telaVisualizarProdutos= telaVisualizarProdutos;
		this.produtoDAO = produtoDAO;
		
	    carregarTabela();
	    }

	    public void carregarTabela() {
	        List<Produto> produtos = produtoDAO.listarProdutos();
	        telaVisualizarProdutos.preencherTabela(produtos);
	    }
		

}
