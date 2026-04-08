package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
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
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.Font;

public class TelaCompras extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaCompras() {
		
		int indiceAtual = 0;
		int itensPorPagina = 3;
		
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[][168.00][211.00][275.00][223.00]", "[179.00][205.00][228.00][]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1 4 1,grow");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[316.00]", "[56.00][56.00][56.00]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Mais informações");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2, "cell 0 1,alignx center");
		
		JButton btnNewButton = new JButton("Adicionar ao carrinho");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton, "cell 0 2,alignx center");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[316.00]", "[56.00][56.00][54.00]"));
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome produto");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2_1 = new JLabel("Mais informações");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_2_1, "cell 0 1,alignx center");
		
		JButton btnNewButton_1 = new JButton("Adicionar ao carrinho");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(btnNewButton_1, "cell 0 2,alignx center");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[316.00]", "[56.00][56.00][56.00]"));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nome produto");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_1_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mais informações");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1_1, "cell 0 1,alignx center");
		
		JButton btnNewButton_1_1 = new JButton("Adicionar ao carrinho");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(btnNewButton_1_1, "cell 0 2,alignx center");
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[254.00]", "[56.00][56.00][55.00]"));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nome produto");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_1_1_1_1, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mais informações");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_2_1_1_1, "cell 0 1,alignx center");
		
		JButton btnNewButton_1_1_1 = new JButton("Adicionar ao carrinho");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(btnNewButton_1_1_1, "cell 0 2,alignx center");
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, "cell 3 2,alignx center,aligny top");

	}
}
