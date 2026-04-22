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
import view.TelaVisualizarProduto;
import view.TelaVisualizarTabela;

public class VisualizarProdutoController {
	
	private TelaVisualizarProduto telaVisualizarProduto;
	private Navegador navegador;

	public VisualizarProdutoController(TelaVisualizarProduto telaVisualizarProduto,  Navegador navegador) {
		super();
		this.telaVisualizarProduto= telaVisualizarProduto;

	    
	    this.telaVisualizarProduto.VoltarTelaCompras(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        navegador.navegarPara("COMPRAS");
		    }
			
		});
	    
	}
}
