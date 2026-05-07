package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

import model.ProdutoDAO;
import model.Produto;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JTextArea;

public class TelaCarrinho extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnConcluir, btnExcluirProduto;
	private JTextArea textArea;
	private JLabel lblContador, lbVoltarCompras;
	private int contadorItens = 0;
	private java.util.List<Produto> carrinho = new java.util.ArrayList<>();
	private java.util.List<Produto> listaProdutos;
	private JTextArea taTotal;
	private JLabel lblNewLabel;

	public TelaCarrinho() {
		setBackground(new Color(221, 235, 247));

		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[95.00][403.00][357.00][169.00,grow]", "[179.00][323.00,grow][228.00][]"));

		lbVoltarCompras = new JLabel("");
		lbVoltarCompras.setIcon(new ImageIcon(TelaCarrinho.class.getResource("/Imagens/botao-voltar40.png")));
		add(lbVoltarCompras, "cell 0 0,alignx center");

		textArea = new JTextArea();
		textArea.setBackground(new Color(221, 235, 247));
		textArea.setEditable(false);
		add(textArea, "flowx,cell 3 0,alignx right");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 1 2 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Pre\u00E7o", "Código" }));
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getColumnModel().getColumn(2).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setWidth(0);

		lblNewLabel = new JLabel("Total:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel, "flowy,cell 3 1");

		taTotal = new JTextArea();
		taTotal.setEditable(false);
		taTotal.setBackground(new Color(221, 235, 247));
		add(taTotal, "cell 3 1,grow");

		btnExcluirProduto = new JButton("Excluir produto do carrinho");
		btnExcluirProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnExcluirProduto, "flowx,cell 1 2,alignx center");

		btnConcluir = new JButton("Concluir Compra");
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnConcluir, "cell 2 2,alignx center");

		lblContador = new JLabel("0");

	}

	public void preencherTabela(java.util.List<model.Produto> produtos) {

		this.listaProdutos = produtos;

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Produto p : produtos) {
			model.addRow(new Object[] { p.getNome(), p.getPreco(), p.getCodigo() });

		}
	}

	public JTable getTable() {
		return table;
	}

	public void atualizarTabela(List<Produto> produtos) {
		preencherTabela(produtos);
	}

	public void Finalizar(ActionListener actionListener) {
		this.btnConcluir.addActionListener(actionListener);
	}

	public int getLinhaSelecionada() {
		return table.getSelectedRow();
	}

	public int getCodigoSelecionado() {
		int linha = table.getSelectedRow();
		if (linha == -1)
			return -1; //
		return (int) table.getValueAt(linha, 2);
	}

	public void atualizarContador(int quantidade) {
		lblContador.setText(String.valueOf(quantidade));
	}

	public void atualizarCarrinhoTexto(int quantidade) {
		textArea.setText("" + quantidade);
	}

	public void atualizarTotal(double total) {
		taTotal.setText(String.format("R$ %.2f", total));
	}

	public void excluirProduto(ActionListener actionListener) {
		this.btnExcluirProduto.addActionListener(actionListener);
	}

	public void concluirCompra(ActionListener actionListener) {
		this.btnConcluir.addActionListener(actionListener);
	}

	public void VoltarCompras(MouseListener actionListener) {
		this.lbVoltarCompras.addMouseListener(actionListener);
	}

}
