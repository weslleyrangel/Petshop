package com.petshop.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo; // Enum para definir o tipo de usuário

    // Construtor padrão
    public Usuario() {}
    
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
}