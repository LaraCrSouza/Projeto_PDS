package model;

import java.util.List;

public class Produto {
   
	private int codigo;
	private String nome;
	private String URL;
	private String marca;
	private String categorias;
	private float PesoBruto;
	private float altura;
	private float largura;
	private float comprimento;
	private double preco;

    
    public Produto() {}

    public Produto(int codigo, String nome, String URL, String marca, String categorias, float PesoBruto, float altura, float largura, float comprimento, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.URL = URL;
        this.marca = marca;
        this.categorias = categorias;
        this.PesoBruto = PesoBruto;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.preco = preco;
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
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCategorias() {
        return categorias;
    }
    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }
    public float getPesoBruto() {
        return PesoBruto;
    }
    public void setPesoBruto(float PesoBruto) {
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
        this.comprimento = comprimento;
    }
    public double getPreco() {
        return  preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

 


}