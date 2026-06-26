package model;

public class Carrinho {
	
	private int UsuarioId;
	private String codigo;

	public Carrinho() {
	}

	public Carrinho(int usuarioId, String codigo) {
		this.UsuarioId = usuarioId;
		this.codigo = codigo;
	}

	public int getUsuarioId() {
		return UsuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		UsuarioId = usuarioId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}