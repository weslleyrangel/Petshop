package com.petshop.controller;

import com.petshop.dao.ServicoDAO;
import com.petshop.dao.ServicoDAOImpl;
import com.petshop.model.Servico;

import java.util.List;

public class ServicoController {
    private ServicoDAO servicoDAO;

    public ServicoController(ServicoDAO servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    public Servico buscarPorId(Long id) {
        return servicoDAO.buscarPorId(id);
    }

    public List<Servico> listarTodos() {
        return servicoDAO.listarTodos();
    }

    public void salvar(Servico servico) {
        servicoDAO.salvar(servico);
    }

    public void atualizar(Servico servico) {
        servicoDAO.atualizar(servico);
    }

    public void excluir(Servico servico) {
        servicoDAO.excluir(servico);
    }
}