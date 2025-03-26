package com.petshop.controller;

import com.petshop.dao.ClienteDAO;
import com.petshop.dao.ClienteDAOImpl;
import com.petshop.model.Cliente;

import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAOImpl();

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarTodos();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public void excluirCliente(Cliente cliente) {
        clienteDAO.excluir(cliente);
    }
}