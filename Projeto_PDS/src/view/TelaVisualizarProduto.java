package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JTextArea;

public class TelaVisualizarProduto extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaVisualizarProduto() {
		
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[][][grow]", "[98.00][grow]"));
		
		JTextArea textArea_1 = new JTextArea();
		add(textArea_1, "cell 2 0,grow");
		
		JTextArea textArea = new JTextArea();
		add(textArea, "cell 2 1,grow");

	}

}
