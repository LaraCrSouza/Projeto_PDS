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
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class TelaCadastrarProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfURL;
	private JTextField tfPesoBruto;
	private JTextField tfAltura;
	private JTextField tfLargura;
	private JTextField tfComprimento;
	private JTextField tfPreco;
	private JButton btnCadastrarP;
	private JLabel lbIrTabela;
	private JComboBox cbMarca;
	private JComboBox cbCategorias;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProduto() {
		
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(117, 162, 244));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[][grow][]"));
		
		this.lbIrTabela = new JLabel("");
		this.lbIrTabela.setIcon(new ImageIcon(TelaCadastrarProduto.class.getResource("/Imagens/tabela-de-edicao40.png")));
		this.lbIrTabela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(this.lbIrTabela, "cell 0 1,growx,aligny top");
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(TelaCadastrarProduto.class.getResource("/Imagens/sair30.png")));
		panel.add(lblNewLabel_10, "cell 0 2,alignx center,growy");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(221, 235, 247));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("debug, insets 15 0 0 0", "[]5[grow]5[200px,grow]5[grow]5[grow]", "[][][][][][][][][][][][][][][][][][]"));
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastrarProduto.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg60.png")));
		panel_1.add(lblNewLabel, "cell 4 0,alignx center");
		
		JLabel lbCodigo = new JLabel("Código");
		lbCodigo.setForeground(new Color(17, 79, 166));
		lbCodigo.setBackground(new Color(255, 255, 255));
		lbCodigo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbCodigo, "cell 1 1,alignx trailing");
		
		this.tfCodigo = new JTextField();
		this.tfCodigo.setBackground(new Color(255, 255, 255));
		panel_1.add(this.tfCodigo, "cell 2 1 2 1,grow");
		this.tfCodigo.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setForeground(new Color(17, 79, 166));
		lbNome.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbNome, "cell 1 3,alignx trailing");
		
		this.tfNome = new JTextField();
		this.tfNome.setBackground(new Color(255, 255, 255));
		panel_1.add(this.tfNome, "cell 2 3 2 1,grow");
		this.tfNome.setColumns(10);
		
		JLabel lbURL = new JLabel("URL: ");
		lbURL.setForeground(new Color(17, 79, 166));
		lbURL.setBackground(new Color(189, 201, 255));
		lbURL.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbURL, "cell 1 5,alignx trailing");
		
		this.tfURL = new JTextField();
		this.tfURL.setBackground(new Color(255, 255, 255));
		panel_1.add(this.tfURL, "cell 2 5 2 1,grow");
		this.tfURL.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca:");
		lbMarca.setForeground(new Color(17, 79, 166));
		lbMarca.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbMarca, "cell 1 7,alignx trailing");
		
		this.cbMarca = new JComboBox();
		this.cbMarca.setBackground(new Color(107, 158, 228));
		panel_1.add(this.cbMarca, "cell 2 7 2 1,grow");
		
		JLabel lbCategoria = new JLabel("Categorias:");
		lbCategoria.setForeground(new Color(17, 79, 166));
		lbCategoria.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbCategoria, "cell 1 9,alignx trailing");
		
		this.cbCategorias = new JComboBox();
		this.cbCategorias.setBackground(new Color(107, 158, 228));
		panel_1.add(this.cbCategorias, "cell 2 9 2 1,grow");
		
		JLabel lbPreco = new JLabel("Preço:");
		lbPreco.setForeground(new Color(17, 79, 166));
		lbPreco.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbPreco, "cell 1 11,alignx trailing");
		
		this.tfPreco = new JTextField();
		panel_1.add(this.tfPreco, "cell 2 11 2 1,grow");
		this.tfPreco.setColumns(10);
		
		JLabel lbPesoBruto = new JLabel("Peso Bruto:");
		lbPesoBruto.setForeground(new Color(17, 79, 166));
		lbPesoBruto.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lbPesoBruto, "cell 1 13,alignx center,aligny center");
		
		JLabel lbAltura = new JLabel("Altura:");
		lbAltura.setForeground(new Color(17, 79, 166));
		lbAltura.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lbAltura, "cell 2 13,alignx center");
		
		JLabel lbLargura = new JLabel("Largura:");
		lbLargura.setForeground(new Color(17, 79, 166));
		lbLargura.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lbLargura, "cell 3 13,alignx center");
		
		JLabel lbComprimento = new JLabel("Comprimento:");
		lbComprimento.setForeground(new Color(17, 79, 166));
		lbComprimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lbComprimento, "cell 4 13,alignx center");
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "flowx,cell 1 14,alignx center");
		
		this.tfPesoBruto = new JTextField();
		this.tfPesoBruto.setBackground(new Color(255, 255, 255));
		this.tfPesoBruto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(this.tfPesoBruto);
		this.tfPesoBruto.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Kg");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "flowx,cell 2 14,alignx center");
		
		this.tfAltura = new JTextField();
		this.tfAltura.setBackground(new Color(255, 255, 255));
		this.tfAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(this.tfAltura);
		this.tfAltura.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cm");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "flowx,cell 4 14,alignx center");
		
		this.tfComprimento = new JTextField();
		this.tfComprimento.setBackground(new Color(255, 255, 255));
		this.tfComprimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(this.tfComprimento);
		this.tfComprimento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cm");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "flowx,cell 3 14,alignx center");
		
		this.tfLargura = new JTextField();
		this.tfLargura.setBackground(new Color(255, 255, 255));
		this.tfLargura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(this.tfLargura);
		this.tfLargura.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cm");
		panel_4.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		this.btnCadastrarP = new JButton("Cadastrar produto");
		this.btnCadastrarP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(this.btnCadastrarP, "cell 2 16 2 1,alignx center");

	}
	public JComboBox getcbCategorias() {
		return getcbCategorias();
	}
    public void setcbTipoUsuario(JComboBox cbCategorias) {
		this.cbCategorias= cbCategorias;
	}
    public JComboBox getcbMarca() {
		return getcbCategorias();
	}
    public void setcbMarca(JComboBox cbMarca) {
		this.cbMarca= cbMarca;
	}
	
    public JTextField gettfNome() {
		return tfNome;
	}
    
    public void settfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}
    
    public JTextField gettfCodigo() {
		return tfCodigo;
	}
    
    public void settfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}
    public JTextField gettfURL() {
		return tfURL;
	}
    
    public void settfURL(JTextField tfURL) {
		this.tfURL = tfURL;
    }
    
    public JTextField gettfPesoBruto() {
		return tfPesoBruto;
	}
    
    public void settfPesoBruto(JTextField tfPesoBruto) {
		this.tfPesoBruto = tfPesoBruto;
    }
    public JTextField gettfAltura() {
		return tfAltura;
	}
    
    public void settfAltura(JTextField tfAltura) {
		this.tfAltura = tfAltura;
    }
    public JTextField gettfLargura() {
		return tfAltura;
	}
    
    public void settfLargura(JTextField tfLargura) {
		this.tfLargura = tfLargura;
    }
    public JTextField gettfComprimento() {
		return tfComprimento;
	}
    
    public void settfComprimento(JTextField tfComprimento) {
		this.tfComprimento = tfComprimento;
    }
    public JTextField gettfPreco() {
		return tfPreco;
	}
    
    public void settfPreco(JTextField tfPreco) {
		this.tfPreco = tfPreco;
    }

    
	public void cadastrar(ActionListener actionListener) {
		this.btnCadastrarP.addActionListener(actionListener);
	}
	
	public void irParaTabela(MouseListener actionListener) {
		this.lbIrTabela.addMouseListener(actionListener);
	}

}
