package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

public class CarrinhoDeCompra extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CarrinhoDeCompra() {
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow]", "[553.00][72.00]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 235, 247));
		add(panel, "cell 0 0,grow");

	}

}
