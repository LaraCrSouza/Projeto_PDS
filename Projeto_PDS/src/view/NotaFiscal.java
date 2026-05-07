package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;

public class NotaFiscal extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextArea taCod, taNome, taQntd, taVlUnit, taVlTotal, taQntdTotal, taFormaPagamento, taValorPago;

	/**
	 * Create the panel.
	 */
	public NotaFiscal() {
		setLayout(new MigLayout("", "[142.00][grow][grow][grow][grow]", "[][grow][38.00][38.00][35.00]"));

		JLabel lblNewLabel = new JLabel("Cód");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel, "cell 0 0,alignx center");

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1, "cell 1 0,alignx center");

		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_2, "cell 2 0,alignx center");

		JLabel lblNewLabel_4 = new JLabel("Vl Unit.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_4, "cell 3 0,alignx center");

		JLabel lblNewLabel_5 = new JLabel("Vl Total");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_5, "cell 4 0,alignx center");

		taCod = new JTextArea();
		add(taCod, "cell 0 1,grow");

		taNome = new JTextArea();
		add(taNome, "cell 1 1,grow");

		taQntd = new JTextArea();
		add(taQntd, "cell 2 1,grow");

		taVlUnit = new JTextArea();
		add(taVlUnit, "cell 3 1,grow");

		taVlTotal = new JTextArea();
		add(taVlTotal, "cell 4 1,grow");

		JLabel lblNewLabel_7 = new JLabel("QTD. Total de Itens");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_7, "cell 0 2,alignx right");

		taQntdTotal = new JTextArea();
		add(taQntdTotal, "cell 2 2,grow");

		JLabel lblNewLabel_8 = new JLabel("Forma de pagamento");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_8, "cell 0 3,alignx right");

		taFormaPagamento = new JTextArea();
		add(taFormaPagamento, "cell 2 3,grow");

		JLabel lblNewLabel_9 = new JLabel("Valor Pago");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_9, "cell 0 4,alignx right");

		taValorPago = new JTextArea();
		add(taValorPago, "cell 2 4,grow");

	}

	public JTextArea getTaCod() {
		return taCod;
	}

	public void setTaCod(JTextArea taCod) {
		this.taCod = taCod;
	}

	public JTextArea getTaNome() {
		return taNome;
	}

	public void setTaNome(JTextArea taNome) {
		this.taNome = taNome;
	}

	public JTextArea getTaQntd() {
		return taQntd;
	}

	public void setTaQntd(JTextArea taQntd) {
		this.taQntd = taQntd;
	}

	public JTextArea getTaVlUnit() {
		return taVlUnit;
	}

	public void setTaVlUnit(JTextArea taVlUnit) {
		this.taVlUnit = taVlUnit;
	}

	public JTextArea getTaVlTotal() {
		return taVlTotal;
	}

	public void setTaVlTotal(JTextArea taVlTotal) {
		this.taVlTotal = taVlTotal;
	}

	public JTextArea getTaQntdTotal() {
		return taQntdTotal;
	}

	public void setTaQntdTotal(JTextArea taQntdTotal) {
		this.taQntdTotal = taQntdTotal;
	}

	public JTextArea getTaFormaPagamento() {
		return taFormaPagamento;
	}

	public void setTaFormaPagamento(JTextArea taFormaPagamento) {
		taFormaPagamento = taFormaPagamento;
	}

	public JTextArea getTaValorPago() {
		return taValorPago;
	}

	public void setTaValorPago(JTextArea taValorPago) {
		this.taValorPago = taValorPago;
	}

	public void preencherNota(java.util.List<model.Produto> carrinho, String formaPagamento, double total) {
		java.util.Map<Integer, Integer> quantidades = new java.util.LinkedHashMap<>();
		java.util.Map<Integer, model.Produto> produtos = new java.util.LinkedHashMap<>();

		for (model.Produto p : carrinho) {
			int codigo = p.getCodigo();
			produtos.put(codigo, p);
			quantidades.put(codigo, quantidades.getOrDefault(codigo, 0) + 1);
		}

		StringBuilder codigos = new StringBuilder();
		StringBuilder nomes = new StringBuilder();
		StringBuilder vlUnit = new StringBuilder();
		StringBuilder vlTotal = new StringBuilder();
		StringBuilder qtds = new StringBuilder();

		for (int codigo : produtos.keySet()) {
			model.Produto p = produtos.get(codigo);
			int qtd = quantidades.get(codigo);
			codigos.append(p.getCodigo()).append("\n");
			nomes.append(p.getNome()).append("\n");
			qtds.append(qtd).append("\n");
			vlUnit.append(String.format("R$ %.2f", p.getPreco())).append("\n");
			vlTotal.append(String.format("R$ %.2f", p.getPreco() * qtd)).append("\n");
		}

		taCod.setText(codigos.toString());
		taNome.setText(nomes.toString());
		taQntd.setText(qtds.toString());
		taVlUnit.setText(vlUnit.toString());
		taVlTotal.setText(String.format("R$ %.2f", total));
		taQntdTotal.setText(String.valueOf(carrinho.size()));
		taFormaPagamento.setText(formaPagamento);
		taValorPago.setText(String.format("R$ %.2f", total));
	}

}
