package model;

public class Produto {
   
	private int codigo;
	private String nome;
	private String URL;
	private String Marca;
	private String Categorias;
	private int PesoBruto;
	private int altura;
	private int largura;
	private int comprimento;
	private double preco;

    // Construtores
    public Produto() {}

    public Produto(int codigo, String nome, String URL, String Marca, String Categorias, int PesoBruto, int altura, int largura, int comprimento, double preco) {
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

    public String getEmail() {
        return URL;
    }

    public void setEmail(String email) {
        this.URL = URL;
    }

    public String gettipoUsuario() {
        return Marca;
    }
    public void settipoUsuario(String tipoUsuario) {
        this.Marca = tipoUsuario;
    }
    public String getCategorias() {
        return Categorias;
    }
    public void setCategorias(String Categorias) {
        this.Categorias = Categorias;
    }
    public int getPesoBruto() {
        return PesoBruto;
    }
    public void setPesoBruto(int tipoUsuario) {
        this.PesoBruto = PesoBruto;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}