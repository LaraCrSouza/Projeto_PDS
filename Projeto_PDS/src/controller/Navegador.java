package controller;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Usuario;
import view.Janela;
import view.TelaCarrinho;
import view.TelaCompras;
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
	private TelaCompras telaCompras;
	private int usuarioLogadoId;
	
	

	public void setUsuarioLogadoId(int id) {
	    this.usuarioLogadoId = id;
	}
	
	public int getUsuarioLogadoId() {
	    return usuarioLogadoId;
	}

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
	
	public void setTelaCompras (TelaCompras compras) {
		this.telaCompras = compras;
	}
	public TelaCompras  getTelaCompras() {
		return telaCompras;
	}

	public TelaFinalizarCompra getFinalizar() {
		return finalizar;
	}

	public void setFinalizar(TelaFinalizarCompra finalizar) {
		this.finalizar = finalizar;
	}
	

	

}
