package com.petshop.dao;

import com.petshop.model.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAOImpl implements ServicoDAO {
    private List<Servico> servicos = new ArrayList<>();

    @Override
    public Servico buscarPorId(Long id) {
        return servicos.stream()
                .filter(servico -> servico.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Servico> listarTodos() {
        return new ArrayList<>(servicos);
    }

    @Override
    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    @Override
    public void atualizar(Servico servico) {
        int index = servicos.indexOf(buscarPorId(servico.getId()));
        if (index != -1) {
            servicos.set(index, servico);
        }
    }

    @Override
    public void excluir(Servico servico) {
        servicos.removeIf(s -> s.getId().equals(servico.getId()));
    }
}