package model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    String tipoUsuario;

    // Construtores
    public Usuario() {}

    public Usuario(int id, String nome, String email, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettipoUsuario() {
        return tipoUsuario;
    }
    public void settipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}