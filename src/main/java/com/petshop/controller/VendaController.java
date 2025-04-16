package com.petshop.controller;

import com.petshop.dao.VendaDAO;
import com.petshop.dao.VendaDAOImpl;
import com.petshop.model.Venda;

import java.util.List;

public class VendaController {
    private VendaDAO vendaDAO = new VendaDAOImpl();

    public void adicionarVenda(Venda venda) {
        vendaDAO.salvar(venda);
    }

    public List<Venda> listarVendas() {
        return vendaDAO.listarTodos();
    }

    public Venda buscarVendaPorId(Long id) {
        return vendaDAO.buscarPorId(id);
    }

    public void atualizarVenda(Venda venda) {
        vendaDAO.atualizar(venda);
    }

    public void excluirVenda(Venda venda) {
        vendaDAO.excluir(venda);
    }
}