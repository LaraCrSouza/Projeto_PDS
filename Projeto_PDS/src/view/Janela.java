package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dimension;

/**
 * Classe que representa a janela da aplicação.
 */
public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	/**
	 * Construtor da classe.
	 */
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 675);

		this.cardLayout = new CardLayout();

		this.contentPane = new JPanel(this.cardLayout);
		this.contentPane.setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
	}

	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(tela, nome);
	}

	public void mostrarTela(String nome) {

	    if (nome.equals("LOGIN")) {
	        setTitle("Login");
	    }
	    else if (nome.equals("CADASTRO USUARIO")) {
	        setTitle("Cadastro");
	    }
	    else if (nome.equals("CADASTRO PRODUTO")) {
	        setTitle("Cadastro de Produto");
	    }
	    else if (nome.equals("COMPRAS")) {
	        setTitle("Compras");
	    }
	    else if (nome.equals("CARRINHO")) {
	        setTitle("Carrinho");
	    }
	    else if (nome.equals("FINALIZAR COMPRA")) {
	        setTitle("Finalizar Compra");
	    }

	    this.cardLayout.show(this.contentPane, nome);
	    this.pack();
	}
}
