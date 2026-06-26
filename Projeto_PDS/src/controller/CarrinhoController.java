package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

import model.CarrinhoDAO;
import model.Produto;
import view.TelaCarrinho;

public class CarrinhoController {

	private TelaCarrinho telaCarrinho;
	private List<Produto> carrinho;
	private Navegador navegador;
	private CarrinhoDAO carrinhoDAO;

	public CarrinhoController(TelaCarrinho telaCarrinho, List<Produto> carrinho, Navegador navegador,
			CarrinhoDAO carrinhoDAO) {
		this.telaCarrinho = telaCarrinho;
		this.carrinho = carrinho;
		this.navegador = navegador;
		this.carrinhoDAO = carrinhoDAO;

		this.telaCarrinho.excluirProduto(e -> {
			excluirProduto();
		});

		this.telaCarrinho.concluirCompra(e -> {
			concluirCompra();
		});
		this.telaCarrinho.VoltarCompras(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.getTelaCompras().atualizarCarrinhoTexto(carrinho.size());
				navegador.getTelaCompras().atualizarContador(carrinho.size());
				navegador.navegarPara("COMPRAS");

			}
		});
	}

	public void atualizarTela() {
		telaCarrinho.preencherTabela(carrinho);
		telaCarrinho.atualizarTotal(calcularTotal());
	}

	private void excluirProduto() {
		int linha = telaCarrinho.getLinhaSelecionada();
		if (linha == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {

			try {

				Produto produto = carrinho.get(linha);
				carrinhoDAO.removerProduto(produto.getCodigo());
				carrinho.remove(linha);
				atualizarTela();
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao remover produto. Tente novamente.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private double calcularTotal() {
		double total = 0;
		for (Produto p : carrinho) {
			total += p.getPreco();
		}
		return total;
	}

	private void concluirCompra() {
		Double total = calcularTotal();
		navegador.getFinalizar().preencherResumo(carrinho.size(), total);
		navegador.navegarPara("FINALIZAR COMPRA");
	}
}