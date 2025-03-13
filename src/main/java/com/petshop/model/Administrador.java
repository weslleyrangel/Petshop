package com.petshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Administrador extends Usuario {
    @Column
    private String nivelAcesso;

    public Administrador() {
        this.setTipo(TipoUsuario.ADMINISTRADOR);
    }

    // Getters e Setters
    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }
}