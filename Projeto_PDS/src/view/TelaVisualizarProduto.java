package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class TelaVisualizarProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea taCodigo, taNome, taURL, taMarca, taCategorias;
    private JTextArea taPesoBruto, taAltura, taLargura, taComprimento;
    private JLabel lbVoltarTelaCompras;

	/**
	 * Create the panel.
	 */
	public TelaVisualizarProduto() {
		
		
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[239.00][grow]"));
		
		lbVoltarTelaCompras = new JLabel("");
		lbVoltarTelaCompras.setIcon(new ImageIcon(TelaVisualizarProduto.class.getResource("/Imagens/botao-voltar40.png")));
		add(lbVoltarTelaCompras, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel, "cell 1 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1, "cell 2 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_2 = new JLabel("URL");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_2, "cell 3 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_3 = new JLabel("Marca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_3, "cell 4 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_4 = new JLabel("Categorias");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_4, "cell 5 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_5 = new JLabel("Peso Bruto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_5, "cell 6 0,alignx center,aligny bottom");
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblAltura, "cell 7 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_6 = new JLabel("Largura");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_6, "cell 8 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_7 = new JLabel("Comprimento");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_7, "cell 9 0,alignx center,aligny bottom");
		
		taCodigo = new JTextArea();
		taCodigo.setEditable(false);
		add(taCodigo, "cell 1 1,grow");
		
		taNome = new JTextArea();
		taNome.setEditable(false);
		add(taNome, "cell 2 1,grow");
		
		taURL = new JTextArea();
		taURL.setEditable(false);
		add(taURL, "cell 3 1,grow");
		
		taMarca = new JTextArea();
		taMarca.setEditable(false);
		add(taMarca, "cell 4 1,grow");
		
		taCategorias = new JTextArea();
		taCategorias.setEditable(false);
		add(taCategorias, "cell 5 1,grow");
		
		taPesoBruto = new JTextArea();
		taPesoBruto.setEditable(false);
		add(taPesoBruto, "cell 6 1,grow");
		
		taAltura = new JTextArea();
		taAltura.setEditable(false);
		add(taAltura, "cell 7 1,grow");
		
		taLargura = new JTextArea();
		taLargura.setEditable(false);
		add(taLargura, "cell 8 1,grow");
		
		taComprimento = new JTextArea();
		taComprimento.setEditable(false);
		add(taComprimento, "cell 9 1,grow");

	}
	
	 public void preencherDados(model.Produto p) {
	        taCodigo.setText(String.valueOf(p.getCodigo()));
	        taNome.setText(p.getNome());
	        taURL.setText(p.getURL());
	        taMarca.setText(p.getMarca());
	        taCategorias.setText(p.getCategorias());
	        taPesoBruto.setText(String.valueOf(p.getPesoBruto()));
	        taAltura.setText(String.valueOf(p.getAltura()));
	        taLargura.setText(String.valueOf(p.getLargura()));
	        taComprimento.setText(String.valueOf(p.getComprimento()));
	    }
	 public void VoltarTelaCompras(MouseListener actionListener) {
			this.lbVoltarTelaCompras.addMouseListener(actionListener);
		}

}
