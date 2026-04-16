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
	
	private java.util.List<Produto> carrinho = new java.util.ArrayList<>();
	private java.util.List<Produto> listaProdutos;
	private TelaCompras compras;
	private ProdutoDAO produtoDAO;

	public  ComprasController(TelaCompras telaCompras, ProdutoDAO produtoDAO) {
		super();
		this.compras = telaCompras;
		this.produtoDAO = produtoDAO;
		
		carregarProdutos(); 
		
		this.compras.AdicionarAoCarrinho(e->{
			adicionarCarrinho();
		});
	
	    
	    }
	
	private void carregarProdutos() {
		listaProdutos = produtoDAO.listarProdutos();
        compras.preencherTabela(listaProdutos);
    }
	private void adicionarCarrinho() {

	    int linha = compras.getLinhaSelecionada();

	    if (linha == -1) {
	        JOptionPane.showMessageDialog(null, "Selecione um produto!");
	        return;
	    }

	    int codigo = compras.getCodigoSelecionado();

	    for (Produto p : listaProdutos) {
	        if (p.getCodigo() == codigo) {
	            carrinho.add(p);
	            
	            compras.atualizarCarrinhoTexto(carrinho.size());
	            compras.atualizarContador(carrinho.size());
	            break;
	        }
	    }
	}

	
}
