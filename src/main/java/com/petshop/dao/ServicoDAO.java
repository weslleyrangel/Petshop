package com.petshop.dao;

import java.util.List;

import com.petshop.model.Servico;

public interface ServicoDAO {
    Servico buscarPorId(Long id);
    List<Servico> listarTodos();
    void salvar(Servico servico);
    void atualizar(Servico servico);
    void excluir(Servico servico);
}