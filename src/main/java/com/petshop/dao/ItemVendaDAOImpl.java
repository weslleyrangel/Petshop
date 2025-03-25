package com.petshop.dao;

import com.petshop.model.ItemVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ItemVendaDAOImpl implements ItemVendaDAO {
    private EntityManager entityManager;

    public ItemVendaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ItemVenda buscarPorId(Long id) {
        return entityManager.find(ItemVenda.class, id);
    }

    @Override
    public List<ItemVenda> listarTodos() {
        Query query = entityManager.createQuery("SELECT i FROM ItemVenda i");
        return query.getResultList();
    }

    @Override
    public void salvar(ItemVenda itemVenda) {
        entityManager.getTransaction().begin();
        entityManager.persist(itemVenda);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(ItemVenda itemVenda) {
        entityManager.getTransaction().begin();
        entityManager.merge(itemVenda);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(ItemVenda itemVenda) {
        entityManager.getTransaction().begin();
        entityManager.remove(itemVenda);
        entityManager.getTransaction().commit();
    }
}