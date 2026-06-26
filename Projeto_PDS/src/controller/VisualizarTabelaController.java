package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import view.TelaVisualizarTabela;

public class VisualizarTabelaController extends ComponentAdapter {

	private TelaVisualizarTabela telaVisualizarTabela;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private List<Produto> visualizarTabela;
	private EditarProdutoController editarProdutoController;

	public VisualizarTabelaController(TelaVisualizarTabela telaVisualizarTabela, List<Produto> visualizarTabela,
			ProdutoDAO produtoDAO, Navegador navegador, EditarProdutoController editarProdutoController) {
		super();
		this.telaVisualizarTabela = telaVisualizarTabela;
		this.produtoDAO = produtoDAO;
		this.visualizarTabela = visualizarTabela;
		this.navegador = navegador;
		this.editarProdutoController = editarProdutoController;

		telaVisualizarTabela.adicionarOuvinte(this);

		this.telaVisualizarTabela.remover(e -> {
			excluirProduto();
		});

		this.telaVisualizarTabela.editar(e -> {
			int linha = telaVisualizarTabela.getTable().getSelectedRow();
			if (linha == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um produto!");
				return;
			}

			try {
				String codigo = telaVisualizarTabela.getTable().getValueAt(linha, 4).toString();
				Produto produtoSelecionado = produtoDAO.buscarPorCodigo(codigo);

				if (produtoSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado!");
					return;
				}

				editarProdutoController.abrirParaEdicao(produtoSelecionado);
				navegador.navegarPara("EDITAR PRODUTO");
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao buscar o produto. Tente novamente.", "Erro de Conexão",
						JOptionPane.ERROR_MESSAGE);
			}
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
			try {
				Object valorCelula = telaVisualizarTabela.getTable().getValueAt(linha, 4);
				String codigo = valorCelula.toString();
				produtoDAO.excluirProduto(codigo);
				telaVisualizarTabela.atualizarTabela();
				JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao excluir o produto. Tente novamente.", "Erro de Conexão",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void componentShown(ComponentEvent e) {
		try {
			telaVisualizarTabela.atualizarTabela();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de produtos.", "Erro de Conexão",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
