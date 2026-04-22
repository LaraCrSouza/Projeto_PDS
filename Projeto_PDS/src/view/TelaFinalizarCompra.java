package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class TelaFinalizarCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnConcluir;
	private JRadioButton rbDebito, rbCredito;
	private JTextArea taTotal, taQntdProdutos;
	private JLabel lbVoltar;


	public TelaFinalizarCompra() {
		
		setBackground(new Color(221, 235, 247));

		setMinimumSize(new Dimension(975, 634));
		setPreferredSize(new Dimension(975, 634));
		
		setLayout(new MigLayout("", "[][618.00][402.00]", "[][252.00][153.00][205.00]"));
		
		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(TelaFinalizarCompra.class.getResource("/Imagens/botao-voltar40.png")));
		add(lbVoltar, "cell 0 0");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaFinalizarCompra.class.getResource("/Imagens/carrinho-de-supermercado-Logo-Vector.svg-150.png")));
		add(lblNewLabel_3, "cell 1 1,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel, "cell 2 1,grow");
		panel.setLayout(new MigLayout("", "[97.00][][grow]", "[][][grow][][grow][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Resumo da compra");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1, "cell 0 0,aligny bottom");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de produtos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_2, "cell 0 2");
		
		taQntdProdutos = new JTextArea();
		taQntdProdutos.setBackground(new Color(192, 192, 192));
		panel.add(taQntdProdutos, "cell 1 2 2 1");
		
		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_4, "cell 0 4");
		
		taTotal = new JTextArea();
		taTotal.setBackground(new Color(192, 192, 192));
		panel.add(taTotal, "cell 1 4 2 1");
		
		JLabel lblNewLabel = new JLabel("Escolha a forma de pagamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel, "flowx,cell 1 2,alignx center,aligny bottom");
		
		btnConcluir = new JButton("Concluir compra");
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(btnConcluir, "cell 2 2,alignx center,aligny bottom");
		
		javax.swing.ButtonGroup grupo = new javax.swing.ButtonGroup();
		
		
		rbDebito = new JRadioButton("Débito");
		rbDebito.setBackground(new Color(221, 235, 247));
		rbDebito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rbDebito, "flowx,cell 1 3,alignx center,aligny center");
		
		rbCredito = new JRadioButton("Crédito");
		rbCredito.setBackground(new Color(221, 235, 247));
		rbCredito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rbCredito, "cell 1 3,alignx right,aligny center");
		grupo.add(rbDebito);
		grupo.add(rbCredito);

	}
	
	public JRadioButton getrbDebito() {
		return rbDebito;
	}
    public void setrbDebito(JRadioButton rbDebito) {
		this.rbDebito = rbDebito;
	}
    public JRadioButton getrbCredito() {
		return rbCredito;
	}
    public void setrbCredito(JRadioButton rbCredito) {
		this.rbCredito = rbCredito;
	}
    public void finalizarCompra(ActionListener actionListener) {
    	this.btnConcluir.addActionListener(actionListener);
    }
    public void preencherResumo(int qntds, double total) {
		 taQntdProdutos.setText(String.valueOf(qntds));
		 taTotal.setText(String.format("R$ %.2f", total));
	   
    }
    public void Voltar(MouseListener actionListener) {
		this.lbVoltar.addMouseListener(actionListener);
	}

}
