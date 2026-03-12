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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TelaCadastrarProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProduto() {
		
		setMinimumSize(new Dimension(900, 634));
		setPreferredSize(new Dimension(900, 634));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 240, 255));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[][grow][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Tabela");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1, "cell 0 1,growx,aligny top");
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(TelaCadastrarProduto.class.getResource("/Imagens/sair30.png")));
		panel.add(lblNewLabel_10, "cell 0 2,alignx center,growy");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 249, 255));
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{41, 178, 197, 39, 183, 173, 0};
		gridBagLayout.rowHeights = new int[]{60, 24, 39, 24, 39, 24, 39, 25, 39, 25, 39, 24, 39, 20, 35, 39, 31, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gridBagLayout);
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(TelaCadastrarProduto.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg60.png")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 5;
			gbc_lblNewLabel.gridy = 0;
			panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lbCodigo = new JLabel("Código");
		lbCodigo.setForeground(new Color(51, 68, 147));
		lbCodigo.setBackground(new Color(51, 68, 147));
		lbCodigo.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbCodigo = new GridBagConstraints();
		gbc_lbCodigo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lbCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lbCodigo.gridx = 1;
		gbc_lbCodigo.gridy = 1;
		panel_1.add(lbCodigo, gbc_lbCodigo);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.SOUTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setForeground(new Color(51, 68, 147));
		lbNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbNome = new GridBagConstraints();
		gbc_lbNome.anchor = GridBagConstraints.NORTHEAST;
		gbc_lbNome.insets = new Insets(0, 0, 5, 5);
		gbc_lbNome.gridx = 1;
		gbc_lbNome.gridy = 3;
		panel_1.add(lbNome, gbc_lbNome);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.SOUTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lbURL = new JLabel("URL: ");
		lbURL.setForeground(new Color(51, 68, 147));
		lbURL.setBackground(new Color(189, 201, 255));
		lbURL.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbURL = new GridBagConstraints();
		gbc_lbURL.anchor = GridBagConstraints.NORTHEAST;
		gbc_lbURL.insets = new Insets(0, 0, 5, 5);
		gbc_lbURL.gridx = 1;
		gbc_lbURL.gridy = 5;
		panel_1.add(lbURL, gbc_lbURL);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.SOUTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca:");
		lbMarca.setForeground(new Color(51, 68, 147));
		lbMarca.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbMarca = new GridBagConstraints();
		gbc_lbMarca.anchor = GridBagConstraints.NORTHEAST;
		gbc_lbMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lbMarca.gridx = 1;
		gbc_lbMarca.gridy = 7;
		panel_1.add(lbMarca, gbc_lbMarca);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 7;
		panel_1.add(comboBox, gbc_comboBox);
		
		JLabel lbCategoria = new JLabel("Categorias:");
		lbCategoria.setForeground(new Color(51, 68, 147));
		lbCategoria.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbCategoria = new GridBagConstraints();
		gbc_lbCategoria.anchor = GridBagConstraints.NORTHEAST;
		gbc_lbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lbCategoria.gridx = 1;
		gbc_lbCategoria.gridy = 9;
		panel_1.add(lbCategoria, gbc_lbCategoria);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 9;
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_11 = new JLabel("Preço:");
		lblNewLabel_11.setForeground(new Color(51, 68, 147));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 11;
		panel_1.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.anchor = GridBagConstraints.SOUTH;
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridwidth = 3;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 11;
		panel_1.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Peso Bruto:");
		lblNewLabel_4.setForeground(new Color(51, 68, 147));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 13;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Altura:");
		lblNewLabel_2.setForeground(new Color(51, 68, 147));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 13;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Largura:");
		lblNewLabel_3.setForeground(new Color(51, 68, 147));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 13;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Comprimento:");
		lblNewLabel_5.setForeground(new Color(51, 68, 147));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 13;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 14;
		panel_1.add(panel_2, gbc_panel_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(230, 240, 255));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Kg");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 14;
		panel_1.add(panel_3, gbc_panel_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(230, 240, 255));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cm");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_7);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 14;
		panel_1.add(panel_4, gbc_panel_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(230, 240, 255));
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cm");
		panel_4.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.NORTH;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 14;
		panel_1.add(panel_5, gbc_panel_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(230, 240, 255));
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cm");
		lblNewLabel_9.setBackground(new Color(51, 68, 147));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Cadastrar produto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 16;
		panel_1.add(btnNewButton, gbc_btnNewButton);

	}

}
