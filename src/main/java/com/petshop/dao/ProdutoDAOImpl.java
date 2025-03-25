package com.petshop.dao;

import com.petshop.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {
    private EntityManager entityManager;

    public ProdutoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public List<Produto> listarTodos() {
        Query query = entityManager.createQuery("SELECT p FROM Produto p");
        return query.getResultList();
    }

    @Override
    public List<Produto> listarPorCategoria(String categoria) {
        Query query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.categoria = :categoria");
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public void salvar(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean verificarDisponibilidadeEstoque(Long produtoId, int quantidade) {
        Produto produto = buscarPorId(produtoId);
        return produto != null && produto.getQuantidadeEstoque() >= quantidade;
    }

    @Override
    public void atualizarEstoque(Long produtoId, int quantidade) {
        Produto produto = buscarPorId(produtoId);
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            atualizar(produto);
        }
    }
}