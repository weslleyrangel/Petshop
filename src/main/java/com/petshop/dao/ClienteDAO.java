package com.petshop.dao;

import com.petshop.model.Cliente;
import java.util.List;

public interface ClienteDAO {
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    void salvar(Cliente cliente);
    void atualizar(Cliente cliente);
    void excluir(Cliente cliente);
}