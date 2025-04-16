package com.petshop.dao;

import com.petshop.model.Agendamento;
import com.petshop.model.StatusAgendamento;
import com.petshop.model.Usuario;

import java.util.Date;
import java.util.List;

public interface AgendamentoDAO {
    Agendamento buscarPorId(Long id);
    List<Agendamento> listarPorUsuario(Usuario usuario);
    List<Agendamento> listarTodos();
    List<Agendamento> listarPorPet(Long petId);
    List<Agendamento> listarPorData(Date data);
    List<Agendamento> listarPorStatus(StatusAgendamento status);
    void salvar(Agendamento agendamento);
    void atualizar(Agendamento agendamento);
    void excluir(Agendamento agendamento);
    boolean verificarDisponibilidade(Date dataHora, int duracaoMinutos);
}