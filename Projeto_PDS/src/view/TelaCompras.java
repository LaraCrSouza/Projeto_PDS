package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class TelaCompras extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaCompras() {
		
		setMinimumSize(new Dimension(1020, 640));
		setPreferredSize(new Dimension(1020, 640));
		setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, -11, 183, 344);
		add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 11, 183, 220);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaCompras.class.getResource("/Imagens/blue-and-gold-gradient-abstract-border-for-business-or-certificate-png.png")));

	}
}
