package model;

import java.util.List;

public class Produto {
   
	private int codigo;
	private String nome;
	private String URL;
	private String Marca;
	private String Categorias;
	private float PesoBruto;
	private float altura;
	private float largura;
	private float comprimento;
	private double preco;

    // Construtores
    public Produto() {}

    public Produto(int codigo, String nome, String URL, String Marca, String Categorias, float PesoBruto, float altura, float largura, float comprimento, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.URL = URL;
        this.Marca = Marca;
        this.Categorias = Categorias;
        this.PesoBruto = PesoBruto;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getMarca() {
        return Marca;
    }
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    public String getCategorias() {
        return Categorias;
    }
    public void setCategorias(String Categorias) {
        this.Categorias = Categorias;
    }
    public float getPesoBruto() {
        return PesoBruto;
    }
    public void setPesoBruto(float tipoUsuario) {
        this.PesoBruto = PesoBruto;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.largura = largura;
    }
    public double getPreco() {
        return  preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

	public void add(List<Produto> produto) {
		
	}
 


}