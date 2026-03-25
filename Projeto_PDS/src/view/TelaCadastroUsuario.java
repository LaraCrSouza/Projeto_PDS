package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeC;
	private JTextField tfEmailC;
	private JButton btnCadastrar;
	private JComboBox cbTipoUsuario;

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {
		setBackground(new Color(221, 235, 247));

		setMinimumSize(new Dimension(975, 634));
		setPreferredSize(new Dimension(975, 634));
		setLayout(new MigLayout("insets 30 15 30 60, fill, gap 10", "[grow][grow 30][grow, center][grow]", "[grow][grow 3][grow 5][grow 3][grow 5][grow 3][grow 5][grow 3][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg-150.png")));
		add(lblNewLabel_3, "cell 2 0,alignx left,aligny bottom");
		
		JLabel lblNewLabel = new JLabel("Tipo de usuário:");
		lblNewLabel.setForeground(new Color(17, 29, 176));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel, "cell 1 2,alignx trailing");
		
		JComboBox cbTipoUsuario = new JComboBox();
		cbTipoUsuario.setBackground(new Color(255, 255, 255));
		cbTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
		add(cbTipoUsuario, "cell 2 2,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(17, 29, 176));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel_1, "cell 1 4,alignx trailing");
		
		this.tfNomeC = new JTextField();
		this.tfNomeC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(this.tfNomeC, "cell 2 4,grow");
		this.tfNomeC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(17, 29, 176));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel_2, "cell 1 6,alignx trailing");
		
		this.tfEmailC = new JTextField();
		this.tfEmailC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(this.tfEmailC, "cell 2 6,grow");
		this.tfEmailC.setColumns(10);
		
		this.btnCadastrar = new JButton("Cadastrar");
		this.btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btnCadastrar, "cell 2 8,aligny top");
	}
	
		public JComboBox getcbTipoUsuario() {
			return getcbTipoUsuario();
		}
	    public void setcbTipoUsuario(JComboBox cbTipoUsuario) {
			this.cbTipoUsuario = cbTipoUsuario;
		}
		
	    public JTextField gettfNomeC() {
			return tfNomeC;
		}
	    
	    public void settfNomeC(JTextField tfNomeC) {
			this.tfNomeC = tfNomeC;
		}
	    
	    public JTextField gettfEmailC() {
			return tfEmailC;
		}
	    
	    public void settfEmailC(JTextField tfEmailC) {
			this.tfEmailC = tfEmailC;
		}
	
	    
		public void cadastrar(ActionListener actionListener) {
			this.btnCadastrar.addActionListener(actionListener);
		}

}
