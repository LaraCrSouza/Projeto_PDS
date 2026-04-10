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

import model.Produto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(117, 162, 244));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(221, 235, 247));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[71.00,grow][126.00][][][162.00][101.00][grow]", "[][grow][][][]"));
		
		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(TelaVisualizarTabela.class.getResource("/Imagens/botao-voltar40.png")));
		panel_1.add(lbVoltar, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 1 7 1,grow");
		
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
		
		btnRemover = new JButton("Remover Produto");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnRemover, "cell 2 3,grow");
		
		btnEditar = new JButton("Editar produtos");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnEditar, "cell 4 3,alignx center,growy");

	}
	
	public void preencherTabela(List<Produto> produtos) {

	    DefaultTableModel modelo = new DefaultTableModel();

	    modelo.addColumn("Código");
	    modelo.addColumn("Nome");
	    modelo.addColumn("URL");
	    modelo.addColumn("Marca");
	    modelo.addColumn("Categorias");
	    modelo.addColumn("Peso Bruto");
	    modelo.addColumn("Altura");
	    modelo.addColumn("Largura");
	    modelo.addColumn("Comprimento");
	    modelo.addColumn("Preço");

	    for (Produto produto : produtos) {
	        modelo.addRow(new Object[]{
	        	produto.getCodigo(),
	        	produto.getNome(),
	        	produto.getURL(),
	        	produto.getMarca(),
	        	produto.getCategorias(),
	        	produto.getPesoBruto(),
	        	produto.getAltura(),
	        	produto.getLargura(),
	        	produto.getComprimento(),
	        	produto.getPreco()
	        });
	    }

	    table.setModel(modelo);
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

}
