package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import view.EditarProduto;
import view.TelaVisualizarTabela;

public class EditarProdutoController extends ComponentAdapter {

	private EditarProduto editarProduto;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private List<Produto> visualizarTabela;
	private Produto produtoSelecionado;

	public EditarProdutoController(EditarProduto editarProduto, List<Produto> visualizarTabela, ProdutoDAO produtoDAO,
			Navegador navegador, Produto produtoSelecionado) {
		super();
		this.editarProduto = editarProduto;
		this.produtoDAO = produtoDAO;
		this.visualizarTabela = visualizarTabela;
		this.navegador = navegador;
		this.produtoSelecionado = produtoSelecionado;

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

	public void abrirParaEdicao(Produto produto) {
		this.produtoSelecionado = produto;
		carregarDadosNoFormulario();
	}

	private void carregarDadosNoFormulario() {
		editarProduto.gettfCodigo().setText(produtoSelecionado.getCodigo());
		editarProduto.gettfNome().setText(produtoSelecionado.getNome());
		editarProduto.gettfURL().setText(produtoSelecionado.getURL());
		editarProduto.gettfMarca().setText(produtoSelecionado.getMarca());
		editarProduto.gettfPreco().setText(String.valueOf(produtoSelecionado.getPreco()));
		editarProduto.gettfPesoBruto().setText(String.valueOf(produtoSelecionado.getPesoBruto()));
		editarProduto.gettfAltura().setText(String.valueOf(produtoSelecionado.getAltura()));
		editarProduto.gettfLargura().setText(String.valueOf(produtoSelecionado.getLargura()));
		editarProduto.gettfComprimento().setText(String.valueOf(produtoSelecionado.getComprimento()));
		editarProduto.getcbCategorias().setSelectedItem(produtoSelecionado.getCategorias());
	}

	private void atualizarProduto() {
		try {
			String codigoOriginal = produtoSelecionado.getCodigo();

			produtoSelecionado.setNome(editarProduto.gettfNome().getText());
			produtoSelecionado.setCodigo(editarProduto.gettfCodigo().getText());
			produtoSelecionado.setURL(editarProduto.gettfURL().getText());
			produtoSelecionado.setMarca(editarProduto.gettfMarca().getText());
			produtoSelecionado.setCategorias(editarProduto.getcbCategorias().getSelectedItem().toString());
			produtoSelecionado.setPesoBruto(Float.parseFloat(editarProduto.gettfPesoBruto().getText()));
			produtoSelecionado.setAltura(Float.parseFloat(editarProduto.gettfAltura().getText()));
			produtoSelecionado.setLargura(Float.parseFloat(editarProduto.gettfLargura().getText()));
			produtoSelecionado.setComprimento(Float.parseFloat(editarProduto.gettfComprimento().getText()));
			produtoSelecionado.setPreco(Double.parseDouble(editarProduto.gettfPreco().getText()));

			produtoDAO.atualizarProduto(produtoSelecionado, codigoOriginal);

			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
			navegador.navegarPara("VISUALIZAR TABELA");

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"Verifique os campos numéricos (peso, altura, largura, comprimento, preço).");

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto no banco de dados. Tente novamente.",
					"Erro de Conexão", JOptionPane.ERROR_MESSAGE);
		}
	}

}
