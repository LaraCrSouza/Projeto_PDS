package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaVisualizarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaVisualizarProdutos() {
		
		setMinimumSize(new Dimension(900, 634));
		setPreferredSize(new Dimension(900, 634));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][grow][][][]", "[][grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1 5 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "URL", "Marca", "Categorias", "Peso Bruto", "Altura", "Largura", "Comprimento"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Remover Produto");
		panel_1.add(btnNewButton, "cell 2 3");
		
		JButton btnNewButton_1 = new JButton("Editar produtos");
		panel_1.add(btnNewButton_1, "cell 3 3,alignx center");
		
		JButton btnNewButton_2 = new JButton("Visualizar produtos");
		panel_1.add(btnNewButton_2, "cell 4 3");

	}

}
