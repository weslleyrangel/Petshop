package com.petshop.dao;

import java.util.List;

import com.petshop.model.Cliente;

public interface ClienteDAO {
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    void salvar(Cliente cliente);
    void atualizar(Cliente cliente);
    void excluir(Cliente cliente);
}