package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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

public class TelaCompras extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnFinalizar, btnVerMais;
	private JButton btnAdicionarCarrinho;
	/**
	 * Create the panel.
	 */
	public TelaCompras() {
		setBackground(new Color(221, 235, 247));
		
		
		
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[95.00][463.00][460.00][95.00]", "[179.00][323.00][228.00][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 1 3 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Preço", "Código"
			}
		));
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
		
	}
		
		
	public void preencherTabela(java.util.List<model.Produto> produtos) {

		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0);

		    for (model.Produto p : produtos) {
		        model.addRow(new Object[]{
		        	p.getCodigo(),
		            p.getNome(),
		            p.getPreco()
		        });
		        
		    }
		}
	
	public void Finalizar(ActionListener actionListener) {
		this.btnFinalizar.addActionListener(actionListener);
	}
	
	public void VerMais(MouseListener actionListener) {
		this.btnVerMais.addMouseListener(actionListener);
	}

}
