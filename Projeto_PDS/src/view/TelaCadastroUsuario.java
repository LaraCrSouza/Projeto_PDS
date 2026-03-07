package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {

		setMinimumSize(new Dimension(975, 634));
		setPreferredSize(new Dimension(975, 634));
		setLayout(new MigLayout("insets 30 15 30 60, fill, gap 10", "[grow][grow 30][grow, center][grow]", "[grow][grow 3][grow 5][grow 3][grow 5][grow 3][grow 5][grow 3][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg-150.png")));
		add(lblNewLabel_3, "cell 2 0,alignx left,aligny bottom");
		
		JLabel lblNewLabel = new JLabel("Tipo de usuário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel, "cell 1 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		add(comboBox, "cell 2 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textField_1, "cell 2 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_2, "cell 1 6,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textField_2, "cell 2 6,growx");
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNewButton, "cell 2 8,aligny top");
	}

}
