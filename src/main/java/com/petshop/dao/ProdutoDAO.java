package com.petshop.dao;

import com.petshop.model.Produto;
import java.util.List;

public interface ProdutoDAO {
    Produto buscarPorId(Long id);
    List<Produto> listarTodos();
    void salvar(Produto produto);
    void atualizar(Produto produto);
    void excluir(Produto produto);
}