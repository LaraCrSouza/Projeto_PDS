package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import controller.ProdutoTableModel;
import controller.VisualizarTabelaController;
import model.Produto;
import model.ProdutoDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaVisualizarTabela extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	JButton btnRemover, btnEditar;
	JLabel lbVoltar;

	/**
	 * Create the panel.
	 */
	public TelaVisualizarTabela() {

		setMinimumSize(new Dimension(975, 634));
		setPreferredSize(new Dimension(975, 634));
		setLayout(new BorderLayout(0, 0));

		JPanel paneltabelaPatrimonio = new JPanel();
		add(paneltabelaPatrimonio, BorderLayout.CENTER);
		paneltabelaPatrimonio.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][::60px]",
				"[::60px,grow][100px:n,grow][grow][grow][grow]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(221, 235, 247));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[71.00,grow][126.00][][][162.00][101.00][grow]", "[][grow][][][]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 1 7 1,grow");

		table = new JTable();
		atualizarTabela();
		scrollPane.setViewportView(table);

		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(TelaVisualizarTabela.class.getResource("/Imagens/botao-voltar40.png")));
		panel_1.add(lbVoltar, "cell 0 0");

		btnRemover = new JButton("Remover Produto");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnRemover, "cell 2 3,grow");

		btnEditar = new JButton("Editar produtos");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnEditar, "cell 4 3,alignx center,growy");

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void remover(ActionListener actionListener) {
		this.btnRemover.addActionListener(actionListener);
	}

	public void editar(ActionListener actionListener) {
		this.btnEditar.addActionListener(actionListener);
	}

	public void voltar(MouseListener actionListener) {
		this.lbVoltar.addMouseListener(actionListener);
	}

	public void atualizarTabela() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> lista = produtoDAO.listarProduto();
		ProdutoTableModel model = new ProdutoTableModel(lista);
		table.setModel(model);
	}
	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}


}
