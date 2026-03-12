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
import java.awt.Color;

public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {
		setBackground(new Color(242, 249, 255));
		setForeground(new Color(175, 215, 254));

		setMinimumSize(new Dimension(900, 634));
		setPreferredSize(new Dimension(900, 634));
		setLayout(new MigLayout("insets 30 15 30 60, fill, gap 10", "[grow][grow 30][grow, center][grow]", "[grow][grow 3][grow 5][grow 3][grow 5][grow 3][grow 5][grow 3][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg-150.png")));
		add(lblNewLabel_3, "cell 2 0,alignx left,aligny bottom");
		
		JLabel lblNewLabel = new JLabel("Tipo de usuário:");
		lblNewLabel.setForeground(new Color(51, 68, 147));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel, "cell 1 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 0, 128));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		add(comboBox, "cell 2 2,growx");
		comboBox.setBackground(Color.red);
	      
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(51, 68, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel_1, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(230, 240, 255));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textField_1, "cell 2 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(51, 68, 147));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel_2, "cell 1 6,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(230, 240, 255));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textField_2, "cell 2 6,growx");
		textField_2.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btCadastrar, "cell 2 8,alignx left,aligny top");
	}

}
