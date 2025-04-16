package com.petshop.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo; 
    private String telefone;
    private String cpf;
    private String endereco;
    private String sexo;

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone;}

    public String getCpf() { return cpf;}
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEndereco() { return endereco;}
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Usuario() {}

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
    
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
}