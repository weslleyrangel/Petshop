package com.petshop.dao;

import com.petshop.model.Atendimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class AtendimentoDAOImpl implements AtendimentoDAO {
    private EntityManager entityManager;

    public AtendimentoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Atendimento buscarPorId(Long id) {
        return entityManager.find(Atendimento.class, id);
    }

    @Override
    public List<Atendimento> listarTodos() {
        Query query = entityManager.createQuery("SELECT a FROM Atendimento a");
        return query.getResultList();
    }

    @Override
    public List<Atendimento> listarPorPet(Long petId) {
        Query query = entityManager.createQuery("SELECT a FROM Atendimento a WHERE a.pet.id = :petId");
        query.setParameter("petId", petId);
        return query.getResultList();
    }

    @Override
    public void salvar(Atendimento atendimento) {
        entityManager.getTransaction().begin();
        entityManager.persist(atendimento);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Atendimento atendimento) {
        entityManager.getTransaction().begin();
        entityManager.merge(atendimento);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Atendimento atendimento) {
        entityManager.getTransaction().begin();
        entityManager.remove(atendimento);
        entityManager.getTransaction().commit();
    }
}