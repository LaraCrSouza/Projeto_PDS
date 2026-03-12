//package controller;
//
//import model.Usuario;
//import model.UsuarioDAO;
//import view.TelaCadastroUsuario;
//
///**
// * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
// */
//public class CadastroController {
//	private final TelaCadastroUsuario view;
//	private final UsuarioDAO model;
//	private final Navegador navegador;
//
//	/**
//	 * Construtor da classe
//	 * @param view Referência à tela que controla (TelaCadastro).
//	 * @param model Referência ao modelo de dados (CandidatoDAO).
//	 * @param navegador Referência ao elemento que faz a transição de telas.
//	 */
//	public CadastroController(TelaCadastroUsuario view, UsuarioDAO model, Navegador navegador) {
//		this.view = view;
//		this.model = model;
//		this.navegador = navegador;
//
//		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastro for clicado.
//		this.view.cadastrar(e -> {
//			String nome = view.getNome();
//			String formacao = view.getFormacao();
//			String area = view.getArea();
//
//			if(!nome.equals("") &&
//					!formacao.equals("") &&
//					!area.equals("")) {
//
//				Candidato c = new Candidato(nome, formacao, area, false);
//				this.model.adicionar(c);
//
//				this.view.limparFormulario();
//				this.view.exibirMensagem("Sucesso", "Candidato salvo!", 1);
//			}
//			else {
//				this.view.exibirMensagem("Erro", "Preencha todos os campos!", 0);
//			}
//		});
//
//		//Define o que será executado quando o botão 'Próximo' da TelaCadastro for clicado.
//		this.view.proximo(e -> {
//			if(model.listarTodos().size() > 0)
//				this.navegador.navegarPara("CONTRATACAO");
//			else
//				this.view.exibirMensagem("Erro", "Nenhum candidato cadastrado! Cadastre antes de avançar." , 0);
//		});
//
//		//Define o que será executado quando o botão 'Cancelar' da TelaCadastro for clicado.
//		this.view.cancelar(e -> {
//			this.navegador.sair();
//		});
//	}
//
//}
