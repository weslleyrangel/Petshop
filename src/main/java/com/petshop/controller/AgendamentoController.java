package com.petshop.controller;

import com.petshop.dao.AgendamentoDAO;
import com.petshop.dao.AgendamentoDAOImpl;
import com.petshop.model.Agendamento;
import com.petshop.model.StatusAgendamento;

import java.util.Date;
import java.util.List;

public class AgendamentoController {
    private AgendamentoDAO agendamentoDAO;

    public AgendamentoController(AgendamentoDAO agendamentoDAO) {
        this.agendamentoDAO = agendamentoDAO;
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoDAO.buscarPorId(id);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoDAO.listarTodos();
    }

    public List<Agendamento> listarPorPet(Long petId) {
        return agendamentoDAO.listarPorPet(petId);
    }

    public List<Agendamento> listarPorData(Date data) {
        return agendamentoDAO.listarPorData(data);
    }

    public List<Agendamento> listarPorStatus(StatusAgendamento status) {
        return agendamentoDAO.listarPorStatus(status);
    }

    public void salvar(Agendamento agendamento) {
        agendamentoDAO.salvar(agendamento);
    }

    public void atualizar(Agendamento agendamento) {
        agendamentoDAO.atualizar(agendamento);
    }

    public void excluir(Agendamento agendamento) {
        agendamentoDAO.excluir(agendamento);
    }

    public boolean verificarDisponibilidade(Date dataHora, int duracaoMinutos) {
        return agendamentoDAO.verificarDisponibilidade(dataHora, duracaoMinutos);
    }
}