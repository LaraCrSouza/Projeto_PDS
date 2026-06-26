package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.CarrinhoDAO;
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
	private CarrinhoController carrinhoController;
	private CarrinhoDAO carrinhoDAO;

	public FinalizarCompraController(TelaFinalizarCompra finalizar, Navegador navegador, List<Produto> carrinho,
			NotaFiscal notaFiscal, CarrinhoController carrinhoController, CarrinhoDAO carrinhoDAO) {
		super();
		this.finalizar = finalizar;
		this.navegador = navegador;
		this.carrinho = carrinho;
		this.notaFiscal = notaFiscal;
		this.carrinhoController = carrinhoController;
		this.carrinhoDAO = carrinhoDAO;

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
		String formaPagamento = finalizar.getrbDebito().isSelected() ? "Débito" : "Crédito";
		notaFiscal.preencherNota(carrinho, formaPagamento, total);
		notaFiscal.setVisible(true);

		notaFiscal.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {
				try {
					carrinhoDAO.limparCarrinho();
					carrinho.clear();
					carrinhoController.atualizarTela();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao limpar o carrinho. Tente novamente.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
				notaFiscal.removeWindowListener(this); 
			}
		});
	}

}
