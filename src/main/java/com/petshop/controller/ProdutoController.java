package com.petshop.controller;

import com.petshop.dao.ProdutoDAO;
import com.petshop.dao.ProdutoDAOImpl;
import com.petshop.model.Produto;

import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Produto buscarPorId(Long id) {
        return produtoDAO.buscarPorId(id);
    }

    public List<Produto> listarTodos() {
        return produtoDAO.listarTodos();
    }

    public void salvar(Produto produto) {
        produtoDAO.salvar(produto);
    }

    public void atualizar(Produto produto) {
        produtoDAO.atualizar(produto);
    }

    public void excluir(Produto produto) {
        produtoDAO.excluir(produto);
    }
}