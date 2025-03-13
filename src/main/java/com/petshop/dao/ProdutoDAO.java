package com.petshop.dao;

import com.petshop.model.Produto;
import java.util.List;

public interface ProdutoDAO {
    Produto buscarPorId(Long id);
    List<Produto> listarTodos();
    List<Produto> listarPorCategoria(String categoria);
    void salvar(Produto produto);
    void atualizar(Produto produto);
    void excluir(Produto produto);
    boolean verificarDisponibilidadeEstoque(Long produtoId, int quantidade);
    void atualizarEstoque(Long produtoId, int quantidade);
}