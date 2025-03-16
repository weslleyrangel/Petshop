package com.petshop.controller;

import com.petshop.dao.ProdutoDAO;
import com.petshop.model.Produto;
import com.petshop.exception.PetshopException;

import java.util.List;

public class ProdutoController {
    private final ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Produto buscarPorId(Long id) throws PetshopException {
        try {
            return produtoDAO.buscarPorId(id);
        } catch (Exception e) {
            throw new PetshopException("Erro ao buscar produto por ID: " + id, e);
        }
    }

    public List<Produto> listarTodos() throws PetshopException {
        try {
            return produtoDAO.listarTodos();
        } catch (Exception e) {
            throw new PetshopException("Erro ao listar produtos", e);
        }
    }

    public void salvar(Produto produto) throws PetshopException {
        try {
            produtoDAO.salvar(produto);
        } catch (Exception e) {
            throw new PetshopException("Erro ao salvar produto", e);
        }
    }

    public void atualizar(Produto produto) throws PetshopException {
        try {
            produtoDAO.atualizar(produto);
        } catch (Exception e) {
            throw new PetshopException("Erro ao atualizar produto", e);
        }
    }

    public void excluir(Produto produto) throws PetshopException {
        try {
            produtoDAO.excluir(produto);
        } catch (Exception e) {
            throw new PetshopException("Erro ao excluir produto", e);
        }
    }
}