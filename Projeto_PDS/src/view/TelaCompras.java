package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class TelaCompras extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaCompras() {
		
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(new CardLayout(0, 0));
		
		JLabel label = new JLabel("New label");
		add(label, "name_5250422977400");
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, "name_5248342982000");

	}

}
