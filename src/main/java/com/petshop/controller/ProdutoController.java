package com.petshop.controller;

import com.petshop.dao.ProdutoDAO;
import com.petshop.dao.ProdutoDAOImpl;
import com.petshop.model.Produto;

import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO = new ProdutoDAOImpl();

    public void adicionarProduto(Produto produto) {
        produtoDAO.salvar(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarTodos();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoDAO.buscarPorId(id);
    }

    public void atualizarProduto(Produto produto) {
        produtoDAO.atualizar(produto);
    }

    public void excluirProduto(Produto produto) {
        produtoDAO.excluir(produto);
    }
}