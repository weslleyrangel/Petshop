package com.petshop.dao;

import com.petshop.model.Venda;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOImpl implements VendaDAO {
    private List<Venda> vendas = new ArrayList<>();

    @Override
    public Venda buscarPorId(Long id) {
        return vendas.stream()
                .filter(venda -> venda.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Venda> listarTodos() {
        return new ArrayList<>(vendas);
    }

    @Override
    public void salvar(Venda venda) {
        vendas.add(venda);
    }

    @Override
    public void atualizar(Venda venda) {
        int index = vendas.indexOf(buscarPorId(venda.getId()));
        if (index != -1) {
            vendas.set(index, venda);
        }
    }

    @Override
    public void excluir(Venda venda) {
        vendas.removeIf(v -> v.getId().equals(venda.getId()));
    }
}