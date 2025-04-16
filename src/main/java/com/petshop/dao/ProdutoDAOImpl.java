package com.petshop.dao;

import com.petshop.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public Produto buscarPorId(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    @Override
    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void atualizar(Produto produto) {
        int index = produtos.indexOf(buscarPorId(produto.getId()));
        if (index != -1) {
            produtos.set(index, produto);
        }
    }

    @Override
    public void excluir(Produto produto) {
        produtos.removeIf(p -> p.getId().equals(produto.getId()));
    }

    public List<Produto> listarPorCategoria(String categoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean verificarDisponibilidadeEstoque(Long produtoId, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void atualizarEstoque(Long produtoId, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}