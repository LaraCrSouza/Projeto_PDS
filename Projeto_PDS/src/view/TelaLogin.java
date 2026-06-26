package view;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class TelaLogin extends TelaComFundo {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeL;
	private JTextField tfEmailL;
	private JButton btnCadastrase;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setBackground(new Color(221, 235, 247));

		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("insets 30 15 30 60, flowy, gap 10", "[200px,center][][grow][grow]", "[grow][grow 15][grow 5][grow 5][grow 5][grow 3][][][][grow]"));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				TelaLogin.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg-150.png")));
		add(lblNewLabel, "cell 2 0,alignx center,aligny bottom");

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbNome, "cell 1 2,alignx trailing");

		tfNomeL = new JTextField();
		tfNomeL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNomeL, "cell 2 2,grow");
		tfNomeL.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1, "cell 1 4,alignx trailing");

		tfEmailL = new JTextField();
		tfEmailL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfEmailL, "cell 2 4,grow");
		tfEmailL.setColumns(10);

		this.btnLogin = new JButton("Login");
		this.btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(this.btnLogin, "cell 2 6,alignx center,aligny top");
								
										JLabel lblNewLabel_2 = new JLabel("Ainda não tem uma conta?");
										add(lblNewLabel_2, "flowx,cell 2 8");
										lblNewLabel_2.setForeground(new Color(0, 0, 64));
										lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
										this.btnCadastrase = new JButton("Cadastra-se");
										add(btnCadastrase, "cell 2 8,alignx right");
										this.btnCadastrase.setFont(new Font("Tahoma", Font.PLAIN, 15));

	}

	public JTextField gettfNomeL() {
		return tfNomeL;
	}

	public void settfNomeL(JTextField tfNomeL) {
		this.tfNomeL = tfNomeL;
	}

	public JTextField gettfEmailL() {
		return tfEmailL;
	}

	public void settfEmailL(JTextField tfEmailL) {
		this.tfEmailL = tfEmailL;
	}

	public void logar(ActionListener actionListener) {
		this.btnLogin.addActionListener(actionListener);
	}

	public void cadastrarse(ActionListener actionListener) {
		this.btnCadastrase.addActionListener(actionListener);
	}

}
