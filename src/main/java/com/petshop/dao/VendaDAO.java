package com.petshop.dao;

import com.petshop.model.Venda;
import java.util.List;

public interface VendaDAO {
    Venda buscarPorId(Long id);
    List<Venda> listarTodos();
    void salvar(Venda venda);
    void atualizar(Venda venda);
    void excluir(Venda venda);
}