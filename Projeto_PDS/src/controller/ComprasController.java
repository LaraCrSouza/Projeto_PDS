package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.CarrinhoDAO;
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
	private CarrinhoDAO carrinhoDAO;

	public ComprasController(TelaCompras telaCompras, ProdutoDAO produtoDAO, Navegador navegador,
			java.util.List<Produto> carrinho, TelaFinalizarCompra telaFinalizarCompra, CarrinhoDAO carrinhoDAO) {
		super();
		this.compras = telaCompras;
		this.produtoDAO = produtoDAO;
		this.navegador = navegador;
		this.carrinho = carrinho;
		this.telaFinalizarCompra = telaFinalizarCompra;
		this.carrinhoDAO = carrinhoDAO;

		carregarProdutos();

		this.compras.AdicionarAoCarrinho(e -> {
			adicionarCarrinho();
		});

		this.compras.VoltarLogin(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Deseja ir para tela de login?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					navegador.navegarPara("LOGIN");
				}

			}
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

		this.compras.Sair(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	}

	public void carregarProdutos() {
		try {
			listaProdutos = produtoDAO.listarProduto();
			compras.preencherTabela(listaProdutos);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao carregar produtos. Tente novamente.", "Erro de Conexão",
					JOptionPane.ERROR_MESSAGE);
			listaProdutos = new java.util.ArrayList<>();
		}
	}

	private void adicionarCarrinho() {

		int linha = compras.getLinhaSelecionada();

		if (linha == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um produto!");
			return;
		}

		String codigo = compras.getCodigoSelecionado();

		for (Produto p : listaProdutos) {

			if (p.getCodigo().equals(codigo)) {

				if (p.getQuantidade() <= 0) {
					JOptionPane.showMessageDialog(null, "Produto sem estoque!", "Aviso", JOptionPane.WARNING_MESSAGE);
					return;
				}

				carrinho.add(p);

				try {
					carrinhoDAO.adicionarProduto(p.getCodigo());
					compras.atualizarCarrinhoTexto(carrinho.size());
					compras.atualizarContador(carrinho.size());
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao adicionar produto ao carrinho.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

				break;
			}
		}
	}

	private void dispose() {
		int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void finalizarCompra() {

		if (carrinho.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Seu carrinho está vazio");
			return;
		}

		int confirm = JOptionPane.showConfirmDialog(null, "Deseja finalizar sua compra?", "Confirmação",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {

			try {
				for (Produto p : carrinho) {

					produtoDAO.atualizarProduto(p, null);
					p.setQuantidade(p.getQuantidade() - 1);

					if (p.getQuantidade() == 0) {
						JOptionPane.showMessageDialog(null, "O produto " + p.getNome() + " acabou no estoque!");
					}
				}

				telaFinalizarCompra.preencherResumo(carrinho.size(), calcularTotal());

				navegador.navegarPara("FINALIZAR COMPRA");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao finalizar compra. Tente novamente.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
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
		String codigo = compras.getCodigoSelecionado();
		for (Produto p : listaProdutos) {
			if (p.getCodigo().equals(codigo)) {
				navegador.getTelaVisualizarProduto().preencherDados(p);
				navegador.navegarPara("VISUALIZAR PRODUTO");
				break;
			}
		}
	}

}
