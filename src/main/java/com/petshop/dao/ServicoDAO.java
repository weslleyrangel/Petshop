package com.petshop.dao;

import com.petshop.model.Servico;
import java.util.List;

public interface ServicoDAO {
    Servico buscarPorId(Long id);
    List<Servico> listarTodos();
    void salvar(Servico servico);
    void atualizar(Servico servico);
    void excluir(Servico servico);
}