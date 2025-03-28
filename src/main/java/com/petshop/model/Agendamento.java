package com.petshop.model;

import java.util.Date;

public class Agendamento {
    private Long id; // ID do agendamento
    private String cliente; // Nome do cliente
    private Pet pet; // O pet deve ser do tipo Pet
    private Date dataHora; // Data e hora do agendamento
    private String servico; // Serviço a ser realizado
    private String observacoes; // Observações sobre o agendamento
    private String horario; // Horário do agendamento
    private StatusAgendamento status; // Status do agendamento

    public Agendamento(Long id, String cliente, Pet pet, Date dataHora, String servico, String observacoes, String horario, StatusAgendamento status) {
        this.id = id;
        this.cliente = cliente;
        this.pet = pet;
        this.dataHora = dataHora;
        this.servico = servico;
        this.observacoes = observacoes;
        this.horario = horario;
        this.status = status; // Inicializa o status
    }

    // Getters
    public Long getId() {
        return id; // Retorna o ID do agendamento
    }

    public String getCliente() {
        return cliente; // Retorna o nome do cliente
    }

    public Pet getPet() {
        return pet; // Retorna o pet
    }

    public Date getDataHora() {
        return dataHora; // Retorna a data e hora do agendamento
    }

    public String getServico() {
        return servico; // Retorna o serviço
    }

    public String getObservacoes() {
        return observacoes; // Retorna as observações
    }

    public String getHorario() {
        return horario; // Retorna o horário
    }

    public StatusAgendamento getStatus() {
        return status; // Retorna o status do agendamento
    }
}