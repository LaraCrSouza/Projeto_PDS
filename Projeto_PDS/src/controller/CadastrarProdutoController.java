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
	private TelaVisualizarTabela visualizarTabela;
	private ComprasController comprasController;

	public CadastrarProdutoController(TelaCadastrarProduto cadastro, ProdutoDAO produtoDAO, Navegador navegador,
			VisualizarTabelaController visualizarController, TelaVisualizarTabela visualizarTabela,
			ComprasController comprasController) {
		super();
		this.cadastro = cadastro;
		this.produtoDAO = produtoDAO;
		this.navegador = navegador;
		this.visualizarController = visualizarController;
		this.visualizarTabela = visualizarTabela;
		this.comprasController = comprasController;

		this.cadastro.cadastrar(e -> {
			cadastroProduto();
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

	private void cadastroProduto() {

		if (cadastro.gettfNome().getText().isEmpty() || cadastro.gettfCodigo().getText().isEmpty()
				|| cadastro.gettfURL().getText().isEmpty() || cadastro.gettfPesoBruto().getText().isEmpty()
				|| cadastro.gettfAltura().getText().isEmpty() || cadastro.gettfLargura().getText().isEmpty()
				|| cadastro.gettfComprimento().getText().isEmpty() || cadastro.gettfPreco().getText().isEmpty()
				|| cadastro.gettfMarca().getText().isEmpty() || cadastro.gettfQuantidade().getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
			return;
		}

		Object categoria = cadastro.getcbCategorias().getSelectedItem();

		if (categoria == null) {
			JOptionPane.showMessageDialog(null, "Selecione uma categoria");
			return;
		}

		try {

			Produto produto = new Produto();

			produto.setNome(cadastro.gettfNome().getText());
			produto.setCodigo(cadastro.gettfCodigo().getText());
			produto.setURL(cadastro.gettfURL().getText());
			produto.setMarca(cadastro.gettfMarca().getText());
			produto.setCategorias(cadastro.getcbCategorias().getSelectedItem().toString());
			produto.setPesoBruto(Float.parseFloat(cadastro.gettfPesoBruto().getText()));
			produto.setAltura(Float.parseFloat(cadastro.gettfAltura().getText()));
			produto.setLargura(Float.parseFloat(cadastro.gettfLargura().getText()));
			produto.setComprimento(Float.parseFloat(cadastro.gettfComprimento().getText()));
			produto.setPreco(Double.parseDouble(cadastro.gettfPreco().getText()));
			produto.setQuantidade(Integer.parseInt(cadastro.gettfQuantidade().getText()));

			produtoDAO.adicionarProduto(produto);
			visualizarTabela.atualizarTabela();
			comprasController.carregarProdutos();

			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

			limparCampos();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"Verifique se os campos Peso, Altura, Largura, Comprimento, Preço e Quantidade foram preenchidos corretamente.");
		}

		catch (Exception e) {

			String msg = e.getMessage() != null ? e.getMessage() : "";

			if (msg.contains("Duplicate entry") || msg.contains("PRIMARY")) {
				JOptionPane.showMessageDialog(null,
						"O código '" + cadastro.gettfCodigo().getText() + "' já está cadastrado para outro produto!",
						"Código Duplicado", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao salvar o produto no banco de dados. Tente novamente.",
						"Erro de Conexão", JOptionPane.ERROR_MESSAGE);
			}

		}

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
		cadastro.gettfQuantidade().setText("");
	}

}
