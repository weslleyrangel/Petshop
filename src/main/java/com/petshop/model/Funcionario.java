package com.petshop.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Usuario {
    @Column
    private String cargo;

    @Column
    private Date dataContratacao;

    // Construtor padrão
    public Funcionario() {
        this.setTipo(TipoUsuario.FUNCIONARIO);
    }

    // Getters e Setters
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public Date getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(Date dataContratacao) { this.dataContratacao = dataContratacao; }
}