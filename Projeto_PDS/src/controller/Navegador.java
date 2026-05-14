package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Janela;
import view.TelaCarrinho;
import view.TelaFinalizarCompra;
import view.TelaLogin;
import view.TelaVisualizarProduto;

public class Navegador {

	private Janela janela;
	private TelaLogin login;
	private LoginController loginController;
	private CadastroController cadastroController;
	private TelaCarrinho telaCarrinho;
	private TelaFinalizarCompra finalizar;
	private TelaVisualizarProduto telaVisualizarProduto;
	private CarrinhoController carrinhoController;

	
	public void setCarrinhoController(CarrinhoController carrinhoController) {
	    this.carrinhoController = carrinhoController;
	}

	public void setTelaCarrinho(TelaCarrinho telaCarrinho) {
		this.telaCarrinho = telaCarrinho;
	}

	public Navegador(Janela janela, TelaLogin login) {
		this.janela = janela;
		this.login = login;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}

	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);
	}

	public void sair() {
		this.janela.dispose();
	}

	public TelaCarrinho getTelaCarrinho() {
		return telaCarrinho;
	}

	public void setTelaVisualizarProduto(TelaVisualizarProduto t) {
		this.telaVisualizarProduto = t;
	}

	public TelaVisualizarProduto getTelaVisualizarProduto() {
		return telaVisualizarProduto;
	}

}
