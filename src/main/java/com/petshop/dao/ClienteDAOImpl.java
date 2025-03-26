package com.petshop.dao;

import com.petshop.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente buscarPorId(Long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        int index = clientes.indexOf(buscarPorId(cliente.getId()));
        if (index != -1) {
            clientes.set(index, cliente);
        }
    }

    @Override
    public void excluir(Cliente cliente) {
        clientes.removeIf(c -> c.getId().equals(cliente.getId()));
    }
}