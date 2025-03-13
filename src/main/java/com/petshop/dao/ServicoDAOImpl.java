package com.petshop.dao;

import com.petshop.model.Servico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ServicoDAOImpl implements ServicoDAO {
    private EntityManager entityManager;

    public ServicoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Servico buscarPorId(Long id) {
        return entityManager.find(Servico.class, id);
    }

    @Override
    public List<Servico> listarTodos() {
        Query query = entityManager.createQuery("SELECT s FROM Servico s");
        return query.getResultList();
    }

    @Override
    public void salvar(Servico servico) {
        entityManager.getTransaction().begin();
        entityManager.persist(servico);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Servico servico) {
        entityManager.getTransaction().begin();
        entityManager.merge(servico);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Servico servico) {
        entityManager.getTransaction().begin();
        entityManager.remove(servico);
        entityManager.getTransaction().commit();
    }
}