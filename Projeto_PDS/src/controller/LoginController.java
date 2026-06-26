package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.CarrinhoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaLogin;

public class LoginController {

	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	private CarrinhoDAO carrinhoDAO;
	private ProdutoDAO produtoDAO;
	private List<Produto> carrinho;

	public LoginController(TelaLogin login, UsuarioDAO user, Navegador navegador, CarrinhoDAO carrinhoDAO,
			ProdutoDAO produtoDAO, List<Produto> carrinho) {
		super();
		this.login = login;
		this.user = user;
		this.navegador = navegador;
		this.carrinhoDAO = carrinhoDAO;
		this.produtoDAO = produtoDAO;
		this.carrinho = carrinho;

		this.login.logar(e -> {
			verificarCadastroUsuario();
			limparCamposLogin();
		});
		this.login.cadastrarse(e -> {
			navegador.navegarPara("CADASTRO USUARIO");
			limparCamposLogin();
		});
	}

	private void verificarCadastroUsuario() {

		String nomeDigitado = login.gettfNomeL().getText();
		String emailDigitado = login.gettfEmailL().getText();

		if (nomeDigitado.isEmpty() || emailDigitado.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
			return;

		}
		try {

			List<Usuario> usuario = user.listarUsuarios();
			boolean usuarioEncontrado = false;
			String tipoUsuario = "";

			for (Usuario u : usuario) {

				if ("Administrador".equals(u.gettipoUsuario()) && u.getNome().equals(nomeDigitado)
						&& u.getEmail().equals(emailDigitado)) {

					usuarioEncontrado = true;
					tipoUsuario = "Administrador";
					navegador.setUsuarioLogadoId(u.getId());
					break;

				} else if ("Cliente".equals(u.gettipoUsuario()) && u.getNome().equals(nomeDigitado)
						&& u.getEmail().equals(emailDigitado)) {
					usuarioEncontrado = true;
					tipoUsuario = "Cliente";
					navegador.setUsuarioLogadoId(u.getId());
					break;
				}
			}
			if (usuarioEncontrado) {
				if ("Administrador".equals(tipoUsuario)) {
					navegador.navegarPara("CADASTRO PRODUTO");
				} else if ("Cliente".equals(tipoUsuario)) {
					carrinho.clear();

					carrinho.addAll(carrinhoDAO.listarCarrinho(produtoDAO));

					navegador.getTelaCompras().atualizarCarrinhoTexto(carrinho.size());

					navegador.getTelaCarrinho().preencherTabela(carrinho);
					navegador.navegarPara("COMPRAS");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao conectar. Tente novamente mais tarde. ", "Erro de Conexão",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void limparCamposLogin() {
		login.gettfEmailL().setText("");
		login.gettfNomeL().setText("");
	}
}
