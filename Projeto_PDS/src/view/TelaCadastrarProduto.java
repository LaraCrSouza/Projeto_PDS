package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JButton;

public class TelaCadastrarProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProduto() {
		
		setMinimumSize(new Dimension(975, 634));
		setPreferredSize(new Dimension(975, 634));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66, 97, 199));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(217, 223, 255));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("debug, insets 15 0 0 0", "[]5[grow]5[200px]5[grow]5[grow]", "[][][][][][][][][][][][][][][][][][]"));
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastrarProduto.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg60.png")));
		panel_1.add(lblNewLabel, "cell 4 0,alignx center");
		
		JLabel lbCodigo = new JLabel("Código");
		lbCodigo.setBackground(new Color(66, 97, 199));
		lbCodigo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbCodigo, "cell 1 2,alignx trailing");
		
		textField = new JTextField();
		textField.setBackground(new Color(107, 158, 228));
		panel_1.add(textField, "cell 2 2 2 1,growx");
		textField.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setForeground(new Color(0, 0, 0));
		lbNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbNome, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(107, 158, 228));
		panel_1.add(textField_1, "cell 2 4 2 1,growx");
		textField_1.setColumns(10);
		
		JLabel lbURL = new JLabel("URL: ");
		lbURL.setBackground(new Color(189, 201, 255));
		lbURL.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbURL, "cell 1 6,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(107, 158, 228));
		panel_1.add(textField_2, "cell 2 6 2 1,growx");
		textField_2.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca:");
		lbMarca.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbMarca, "cell 1 8,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(107, 158, 228));
		panel_1.add(comboBox, "cell 2 8 2 1,growx");
		
		JLabel lbCategoria = new JLabel("Categorias:");
		lbCategoria.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbCategoria, "cell 1 10,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(107, 158, 228));
		panel_1.add(comboBox_1, "cell 2 10 2 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Peso Bruto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_4, "cell 1 13,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("Altura:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_2, "cell 2 13,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Largura:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_3, "cell 3 13,alignx center");
		
		JLabel lblNewLabel_5 = new JLabel("Comprimento:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_5, "cell 4 13,alignx center");
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "flowx,cell 1 14,alignx center");
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(107, 158, 228));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Kg");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "flowx,cell 2 14,alignx center");
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(107, 158, 228));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cm");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "flowx,cell 4 14,alignx center");
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(107, 158, 228));
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cm");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "flowx,cell 3 14,alignx center");
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(107, 158, 228));
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cm");
		panel_4.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Cadastrar produto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnNewButton, "cell 2 16 2 1,alignx center");

	}

}
