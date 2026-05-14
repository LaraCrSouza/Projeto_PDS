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
import view.TelaCadastroUsuario;
import view.TelaVisualizarTabela;

public class VisualizarTabelaController  extends ComponentAdapter{

	private TelaVisualizarTabela telaVisualizarTabela;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private List<Produto> visualizarTabela;
	
	public VisualizarTabelaController(TelaVisualizarTabela telaVisualizarTabela, List<Produto> visualizarTabela, ProdutoDAO produtoDAO,
			Navegador navegador) {
		super();
		this.telaVisualizarTabela = telaVisualizarTabela;
		this.produtoDAO = produtoDAO;
		this.visualizarTabela =  visualizarTabela;

		telaVisualizarTabela.adicionarOuvinte(this);
		this.telaVisualizarTabela.remover(e -> {
			excluirProduto();
		});

		this.telaVisualizarTabela.editar(e -> {
			atualizarProduto();
		});

		this.telaVisualizarTabela.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarPara("CADASTRO PRODUTO");
			}

		});

	}


	private void excluirProduto() {
	    int linha = telaVisualizarTabela.getLinhaSelecionada();
	    if (linha == -1) {
	        JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
	        return;
	    }
	    
	    int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        Object valorCelula = telaVisualizarTabela.getTable().getValueAt(linha, 0);
	        int codigo = Integer.parseInt(valorCelula.toString());
	 
	        produtoDAO.excluirProduto(codigo); 
	        telaVisualizarTabela.atualizarTabela();
	        JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
	    }
	}

	public void componentShown(ComponentEvent e) {
	    telaVisualizarTabela.atualizarTabela(); 
	}


	private void atualizarProduto() {

		int linhaSelecionada = (int) telaVisualizarTabela.getTable().getSelectedRow();
		int codigo = (int) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 0);

		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um produto!");
			return;
		}

		codigo = (int) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 0);
		String nome = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 1);
		String URL = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 2);
		String marca = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 3);
		String categorias = (String) telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 4);
		float peso = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 5).toString());
		float altura = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 6).toString());
		float largura = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 7).toString());
		float comprimento = Float
				.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 8).toString());
		float PesoBruto = Float.parseFloat(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 9).toString());
		double preco = Double.parseDouble(telaVisualizarTabela.getTable().getValueAt(linhaSelecionada, 10).toString());

		int confirm = JOptionPane.showConfirmDialog(null, "Deseja atualizar?", "Confirmação",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			Produto produto = new Produto(codigo, nome, URL, marca, categorias, PesoBruto, altura, largura, comprimento,
					preco);

			produtoDAO.atualizarProduto(produto);

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		}
		
	}

}
