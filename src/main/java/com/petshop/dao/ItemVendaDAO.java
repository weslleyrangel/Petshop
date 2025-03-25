package com.petshop.dao;

import com.petshop.model.ItemVenda;
import java.util.List;

public interface ItemVendaDAO {
    ItemVenda buscarPorId(Long id);
    List<ItemVenda> listarTodos();
    void salvar(ItemVenda itemVenda);
    void atualizar(ItemVenda itemVenda);
    void excluir(ItemVenda itemVenda);
}