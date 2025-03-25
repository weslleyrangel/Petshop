package com.petshop.controller;

import com.petshop.dao.ServicoDAO;
import com.petshop.model.Servico;
import com.petshop.exception.ServicoException;

import java.util.List;

public class ServicoController {
    private final ServicoDAO servicoDAO;

    public ServicoController(ServicoDAO servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    public Servico buscarPorId(Long id) throws ServicoException {
        try {
            return servicoDAO.buscarPorId(id);
        } catch (Exception e) {
            throw new ServicoException("Erro ao buscar serviço por ID: " + id, e);
        }
    }

    public List<Servico> listarTodos() throws ServicoException {
        try {
            return servicoDAO.listarTodos();
        } catch (Exception e) {
            throw new ServicoException("Erro ao listar serviços", e);
        }
    }

    public void salvar(Servico servico) throws ServicoException {
        try {
            servicoDAO.salvar(servico);
        } catch (Exception e) {
            throw new ServicoException("Erro ao salvar serviço", e);
        }
    }

    public void atualizar(Servico servico) throws ServicoException {
        try {
            servicoDAO.atualizar(servico);
        } catch (Exception e) {
            throw new ServicoException("Erro ao atualizar serviço", e);
        }
    }

    public void excluir(Servico servico) throws ServicoException {
        try {
            servicoDAO.excluir(servico);
        } catch (Exception e) {
            throw new ServicoException("Erro ao excluir serviço", e);
        }
    }
}