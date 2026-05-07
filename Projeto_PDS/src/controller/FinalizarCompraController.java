package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import model.Usuario;
import model.UsuarioDAO;
import view.NotaFiscal;
import view.TelaFinalizarCompra;
import view.TelaLogin;

public class FinalizarCompraController {

	private TelaFinalizarCompra finalizar;
	private Navegador navegador;
	private List<Produto> carrinho;
	private NotaFiscal notaFiscal;

	public FinalizarCompraController(TelaFinalizarCompra finalizar, Navegador navegador, List<Produto> carrinho,
			NotaFiscal notaFiscal) {
		super();
		this.finalizar = finalizar;
		this.navegador = navegador;
		this.carrinho = carrinho;
		this.notaFiscal = notaFiscal;

		this.finalizar.finalizarCompra(e -> {
			finalizarCompra();

		});
		this.finalizar.Voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarPara("CARRINHO");

			}
		});
	}

	private void finalizarCompra() {

		double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();

		if (!finalizar.getrbDebito().isSelected() && !finalizar.getrbCredito().isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento!");
			return;
		}
		if (finalizar.getrbDebito().isSelected()) {
			notaFiscal.preencherNota(carrinho, "Débito", total);
			navegador.navegarPara("NOTA FISCAL");
		} else {
			notaFiscal.preencherNota(carrinho, "Crédito", total);
			navegador.navegarPara("NOTA FISCAL");
		}

	}
}
