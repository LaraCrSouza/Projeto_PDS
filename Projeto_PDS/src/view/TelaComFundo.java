package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaComFundo extends JPanel{
	public TelaComFundo() {
		setForeground(new Color(221, 235, 247));
		setBackground(new Color(221, 235, 247));
	}
	
	
	private Image imagem = new ImageIcon(getClass().getResource("/Imagens/Fundo.png")).getImage();
	
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        }
	
}