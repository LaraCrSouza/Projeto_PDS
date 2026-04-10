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
import view.TelaCompras;


public class ComprasController {
	
	private TelaCompras compras;
	private ProdutoDAO produtoDAO;

	public  ComprasController(TelaCompras compras, ProdutoDAO produtoDAO) {
		super();
		this.compras = compras;
		this.produtoDAO = produtoDAO;
	    
		carregarProdutos();
	    
	    }
	
	private void carregarProdutos() {
        List<Produto> produtos = produtoDAO.listarProdutos();
        compras.preencherTabela(produtos);
    }

	
}
