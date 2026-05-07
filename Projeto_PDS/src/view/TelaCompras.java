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

public class TelaCompras extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnFinalizar, btnVerMais;
	private JButton btnAdicionarCarrinho;
	private JLabel lbIrParaCarrinho;
	private JTextArea textArea;
	private JLabel lblContador;
	private int contadorItens = 0;
	private java.util.List<Produto> carrinho = new java.util.ArrayList<>();
	private java.util.List<Produto> listaProdutos;

	public TelaCompras() {
		setBackground(new Color(221, 235, 247));

		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[95.00][463.00][460.00][95.00]", "[179.00][323.00][228.00][]"));

		textArea = new JTextArea();
		textArea.setBackground(new Color(221, 235, 247));
		textArea.setEditable(false);
		add(textArea, "flowx,cell 3 0,alignx right");

		lbIrParaCarrinho = new JLabel("");
		lbIrParaCarrinho.setIcon(new ImageIcon(TelaCompras.class.getResource("/Imagens/carrinho-de-compras30.png")));
		add(lbIrParaCarrinho, "cell 3 0,alignx right");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 1 3 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Preço", "Código" }));
		scrollPane.setViewportView(table);

		btnVerMais = new JButton("Ver informações adicionais");
		btnVerMais.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnVerMais, "flowx,cell 1 2,alignx center");

		btnFinalizar = new JButton("Finalizar Compra");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnFinalizar, "cell 2 2,alignx center");

		btnAdicionarCarrinho = new JButton("Adicionar ao carrinho");
		btnAdicionarCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnAdicionarCarrinho, "cell 3 2");

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

	public void atualizarTabela(List<Produto> produtos) {
		preencherTabela(produtos);
	}

	public void Finalizar(ActionListener actionListener) {
		this.btnFinalizar.addActionListener(actionListener);
	}

	public void AdicionarAoCarrinho(ActionListener actionListener) {
		this.btnAdicionarCarrinho.addActionListener(actionListener);
	}

	public int getLinhaSelecionada() {
		return table.getSelectedRow();
	}

	public int getCodigoSelecionado() {
		int linha = table.getSelectedRow();
		return (int) table.getValueAt(linha, 2);
	}

	public void atualizarContador(int quantidade) {
		lblContador.setText(String.valueOf(quantidade));
	}

	public void atualizarCarrinhoTexto(int quantidade) {
		textArea.setText("" + quantidade);
	}

	public void IrParaCarrinho(MouseListener actionListener) {
		this.lbIrParaCarrinho.addMouseListener(actionListener);
	}

	public void FinalizarC(ActionListener actionListener) {
		this.btnFinalizar.addActionListener(actionListener);
	}

	public void VerMais(ActionListener actionListener) {
		this.btnVerMais.addActionListener(actionListener);
	}

}
