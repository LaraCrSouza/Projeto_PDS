package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class NotaFiscal extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextArea taCod, taNome, taQntd, taVlUnit, taVlTotal, taQntdTotal, taFormaPagamento, taValorPago;
	private JLabel lblNewLabel_6;

	/**
	 * Create the panel.
	 */
	public NotaFiscal() {

	    setTitle("Cupom Fiscal");
	    getContentPane().setBackground(new Color(221, 235, 247));

	    getContentPane().setLayout(new MigLayout(
	            "",
	            "[60][220][100][120][120][120]",
	            "[][][][][grow][][]"));

	    lblNewLabel_6 = new JLabel("CUPOM FISCAL");
	    lblNewLabel_6.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
	    getContentPane().add(lblNewLabel_6, "cell 0 0 6 1,alignx center");

	    JLabel lblNewLabel = new JLabel("Cód");
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblNewLabel, "cell 0 2,alignx center");

	    JLabel lblNewLabel_1 = new JLabel("Nome");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblNewLabel_1, "cell 1 2,alignx center");

	    JLabel lblNewLabel_2 = new JLabel("Quantidade");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblNewLabel_2, "cell 2 2,alignx center");

	    JLabel lblNewLabel_4 = new JLabel("Vl Unit.");
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblNewLabel_4, "cell 3 2,alignx center");

	    JLabel lblNewLabel_7 = new JLabel("Qtd Total");
	    lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblNewLabel_7, "cell 4 2,alignx center");

	    JLabel lblNewLabel_5 = new JLabel("Vl Total");
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblNewLabel_5, "cell 5 2,alignx center");

	    taCod = new JTextArea();
	    taCod.setEditable(false);
	    taCod.setColumns(10);
	    taCod.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taCod, "cell 0 3,grow");

	    taNome = new JTextArea();
	    taNome.setEditable(false);
	    taNome.setColumns(20);
	    taNome.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taNome, "cell 1 3,grow");

	    taQntd = new JTextArea();
	    taQntd.setEditable(false);
	    taQntd.setColumns(8);
	    taQntd.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taQntd, "cell 2 3,grow");

	    taVlUnit = new JTextArea();
	    taVlUnit.setEditable(false);
	    taVlUnit.setColumns(10);
	    taVlUnit.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taVlUnit, "cell 3 3,grow");

	    taQntdTotal = new JTextArea();
	    taQntdTotal.setEditable(false);
	    taQntdTotal.setColumns(8);
	    taQntdTotal.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taQntdTotal, "cell 4 3,grow");

	    taVlTotal = new JTextArea();
	    taVlTotal.setEditable(false);
	    taVlTotal.setColumns(10);
	    taVlTotal.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taVlTotal, "cell 5 3,grow");

	    JLabel lblPagamento = new JLabel("Forma de pagamento");
	    lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getContentPane().add(lblPagamento, "cell 0 5");

	    taFormaPagamento = new JTextArea();
	    taFormaPagamento.setEditable(false);
	    taFormaPagamento.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taFormaPagamento, "cell 1 5");

	    JLabel lblTotal = new JLabel("TOTAL");
	    lblTotal.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
	    getContentPane().add(lblTotal, "cell 0 6");

	    taValorPago = new JTextArea();
	    taValorPago.setEditable(false);
	    taValorPago.setBackground(new Color(137, 151, 250));
	    getContentPane().add(taValorPago, "cell 1 6");

	    pack();
	    setMinimumSize(new Dimension(700, 350));
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    
	    taCod.setOpaque(false);
	    taNome.setOpaque(false);
	    taQntd.setOpaque(false);
	    taVlUnit.setOpaque(false);
	    taVlTotal.setOpaque(false);
	    taQntdTotal.setOpaque(false);
	    taFormaPagamento.setOpaque(false);
	    taValorPago.setOpaque(false);
	    
	    taCod.setLineWrap(true);
	    taNome.setLineWrap(true);
	    taQntd.setLineWrap(true);
	    taVlUnit.setLineWrap(true);
	    taVlTotal.setLineWrap(true);
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
		this.taFormaPagamento = taFormaPagamento;
	}

	public JTextArea getTaValorPago() {
		return taValorPago;
	}

	public void setTaValorPago(JTextArea taValorPago) {
		this.taValorPago = taValorPago;
	}

	public void preencherNota(java.util.List<model.Produto> carrinho, String formaPagamento, double total) {
		java.util.Map<String, Integer> quantidades = new java.util.LinkedHashMap<>();
		java.util.Map<String, model.Produto> produtos = new java.util.LinkedHashMap<>();

		for (model.Produto p : carrinho) {
			String codigo = p.getCodigo();
			produtos.put(codigo, p);
			quantidades.put(codigo, quantidades.getOrDefault(codigo, 0) + 1);
		}

		StringBuilder codigos = new StringBuilder();
		StringBuilder nomes = new StringBuilder();
		StringBuilder vlUnit = new StringBuilder();
		StringBuilder vlTotal = new StringBuilder();
		StringBuilder qtds = new StringBuilder();

		for (String codigo : produtos.keySet()) {
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
		taVlTotal.setText(vlTotal.toString());
		taQntdTotal.setText(String.valueOf(carrinho.size()));
		taFormaPagamento.setText(formaPagamento);
		taValorPago.setText(String.format("R$ %.2f", total));
	}

	public static void mostrar(java.util.List<model.Produto> carrinho, String formaPagamento, double total) {
		NotaFiscal frame = new NotaFiscal();
		frame.preencherNota(carrinho, formaPagamento, total);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}


}