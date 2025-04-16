package com.petshop.dao;

import com.petshop.model.ItemVenda;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDAOImpl implements ItemVendaDAO {
    private List<ItemVenda> itensVenda = new ArrayList<>();

    @Override
    public ItemVenda buscarPorId(Long id) {
        return itensVenda.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ItemVenda> listarTodos() {
        return new ArrayList<>(itensVenda);
    }

    @Override
    public void salvar(ItemVenda itemVenda) {
        itensVenda.add(itemVenda);
    }

    @Override
    public void atualizar(ItemVenda itemVenda) {
        int index = itensVenda.indexOf(buscarPorId(itemVenda.getId()));
        if (index != -1) {
            itensVenda.set(index, itemVenda);
        }
    }

    @Override
    public void excluir(ItemVenda itemVenda) {
        itensVenda.removeIf(item -> item.getId().equals(itemVenda.getId()));
    }
}