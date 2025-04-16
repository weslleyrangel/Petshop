package com.petshop.controller;

import com.petshop.dao.AgendamentoDAO;
import com.petshop.dao.UsuarioDAO;
import com.petshop.model.Agendamento;
import com.petshop.model.StatusAgendamento;
import com.petshop.model.Usuario;

import java.util.Date;
import java.util.List;

public class AgendamentoController {
    private AgendamentoDAO agendamentoDAO;
    private UsuarioDAO usuarioDAO;

    public AgendamentoController(AgendamentoDAO agendamentoDAO, UsuarioDAO usuarioDAO) {
        this.agendamentoDAO = agendamentoDAO;
        this.usuarioDAO = usuarioDAO;
    }
    
    public void salvar(Agendamento agendamento) {
        agendamentoDAO.salvar(agendamento);
    }
    
    public List<Agendamento> listarAgendamentosPorUsuario(Usuario usuario) {
        return usuarioDAO.listarAgendamentosPorUsuario(usuario);
    }
    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentoDAO.salvar(agendamento);
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoDAO.listarTodos();
    }

    public Agendamento buscarAgendamentoPorId(Long id) {
        return agendamentoDAO.buscarPorId(id);
    }

    public void atualizarAgendamento(Agendamento agendamento) {
        agendamentoDAO.atualizar(agendamento);
    }

    public void excluirAgendamento(Agendamento agendamento) {
        agendamentoDAO.excluir(agendamento);
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

    public boolean verificarDisponibilidade(Date dataHora, int duracaoMinutos) {
        return agendamentoDAO.verificarDisponibilidade(dataHora, duracaoMinutos);
    }
}