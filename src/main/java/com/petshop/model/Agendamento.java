package com.petshop.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Column(nullable = false)
    private String servico;

    @Column(nullable = false)
    private String horario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;
    
    public Agendamento() {}

    
    public Agendamento(Long id, Usuario usuario, Pet pet, Date dataHora, String servico, String horario, StatusAgendamento status) {
        this.id = id;
        this.usuario = usuario;
        this.pet = pet;
        this.dataHora = dataHora;
        this.servico = servico;
        this.horario = horario;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}