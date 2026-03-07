package view;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		
		
	
		
		setMinimumSize(new Dimension(975, 634));
		setPreferredSize(new Dimension(975, 634));
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("debug, insets 30 15 30 60, flowy, gap 10", "[200px,center][][grow][grow]", "[grow][grow 15][grow 5][grow 5][grow 5][grow 3][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg-150.png")));
		panel.add(lblNewLabel, "cell 2 0,alignx center,aligny bottom");
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lbNome, "cell 1 2,alignx trailing");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField, "cell 2 2,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_1, "cell 2 4,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(btnNewButton, "cell 2 6,alignx center,aligny top");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 2 8,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Ainda não tem uma conta?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Cadastra-se");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_1);

			
	}

}
