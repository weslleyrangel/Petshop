package com.petshop.dao;

import com.petshop.model.Agendamento;
import com.petshop.model.StatusAgendamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgendamentoDAOImpl implements AgendamentoDAO {
    private List<Agendamento> agendamentos = new ArrayList<>();

    @Override
    public Agendamento buscarPorId(Long id) {
        return agendamentos.stream()
                .filter(agendamento -> agendamento.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Agendamento> listarTodos() {
        return new ArrayList<>(agendamentos);
    }

    @Override
    public List<Agendamento> listarPorPet(Long petId) {
        List<Agendamento> result = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getPet() != null && agendamento.getPet().getId().equals(petId)) {
                result.add(agendamento);
            }
        }
        return result;
    }

    @Override
    public List<Agendamento> listarPorData(Date data) {
        List<Agendamento> result = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getDataHora().equals(data)) {
                result.add(agendamento);
            }
        }
        return result;
    }

    @Override
    public List<Agendamento> listarPorStatus(StatusAgendamento status) {
        List<Agendamento> result = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getStatus() == status) {
                result.add(agendamento);
            }
        }
        return result;
    }

    @Override
    public void salvar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    @Override
    public void atualizar(Agendamento agendamento) {
        int index = agendamentos.indexOf(buscarPorId(agendamento.getId()));
        if (index != -1) {
            agendamentos.set(index, agendamento);
        }
    }

    @Override
    public void excluir(Agendamento agendamento) {
        agendamentos.removeIf(a -> a.getId().equals(agendamento.getId()));
    }

    @Override
    public boolean verificarDisponibilidade(Date dataHora, int duracaoMinutos) {
        Date fim = new Date(dataHora.getTime() + duracaoMinutos * 60000);
        return agendamentos.stream()
                .noneMatch(agendamento -> 
                    agendamento.getDataHora().after(dataHora) && agendamento.getDataHora().before(fim));
    }
}