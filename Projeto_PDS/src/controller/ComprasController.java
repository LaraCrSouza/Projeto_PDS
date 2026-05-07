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
import view.TelaFinalizarCompra;

public class ComprasController {

	private java.util.List<Produto> listaProdutos;
	private TelaCompras compras;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private List<Produto> carrinho;
	private TelaFinalizarCompra telaFinalizarCompra;

	public ComprasController(TelaCompras telaCompras, ProdutoDAO produtoDAO, Navegador navegador,
			java.util.List<Produto> carrinho, TelaFinalizarCompra telaFinalizarCompra) {
		super();
		this.compras = telaCompras;
		this.produtoDAO = produtoDAO;
		this.navegador = navegador;
		this.carrinho = carrinho;
		this.telaFinalizarCompra = telaFinalizarCompra;

		carregarProdutos();

		this.compras.AdicionarAoCarrinho(e -> {
			adicionarCarrinho();
		});

		this.compras.FinalizarC(e -> {
			finalizarCompra();
		});

		this.compras.IrParaCarrinho(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				irParaCarrinho();

			}
		});
		this.compras.VerMais(e -> {
			verMais();
		});

	}

	private void carregarProdutos() {
		listaProdutos = produtoDAO.listarProduto();
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

	private void finalizarCompra() {

		if (carrinho.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Seu carrinho está vazio");
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(null, "Deseja finalizar sua compra", "Confirmação",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {

			telaFinalizarCompra.preencherResumo(carrinho.size(), calcularTotal());
			navegador.navegarPara("FINALIZAR COMPRA");

		}

	}

	private void irParaCarrinho() {
		navegador.getTelaCarrinho().preencherTabela(carrinho);
		navegador.getTelaCarrinho().atualizarTotal(calcularTotal());
		navegador.navegarPara("CARRINHO");
	}

	private double calcularTotal() {
		double total = 0;
		for (Produto p : carrinho) {
			total += p.getPreco();
		}
		return total;
	}

	private void verMais() {
		int linha = compras.getLinhaSelecionada();
		if (linha == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um produto!");
			return;
		}
		int codigo = compras.getCodigoSelecionado();
		for (Produto p : listaProdutos) {
			if (p.getCodigo() == codigo) {
				navegador.getTelaVisualizarProduto().preencherDados(p);
				navegador.navegarPara("VISUALIZAR PRODUTO");
				break;
			}
		}
	}

}
