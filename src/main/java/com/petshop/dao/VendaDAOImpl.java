package com.petshop.dao;

import com.petshop.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class VendaDAOImpl implements VendaDAO {
    private EntityManager entityManager;

    public VendaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Venda buscarPorId(Long id) {
        return entityManager.find(Venda.class, id);
    }

    @Override
    public List<Venda> listarTodos() {
        Query query = entityManager.createQuery("SELECT v FROM Venda v");
        return query.getResultList();
    }

    @Override
    public void salvar(Venda venda) {
        entityManager.getTransaction().begin();
        entityManager.persist(venda);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Venda venda) {
        entityManager.getTransaction().begin();
        entityManager.merge(venda);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Venda venda) {
        entityManager.getTransaction().begin();
        entityManager.remove(venda);
        entityManager.getTransaction().commit();
    }
}