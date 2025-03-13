package com.petshop.dao;

import com.petshop.model.Agendamento;
import com.petshop.model.StatusAgendamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Date;
import java.util.List;

public class AgendamentoDAOImpl implements AgendamentoDAO {
    private EntityManager entityManager;

    public AgendamentoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Agendamento buscarPorId(Long id) {
        return entityManager.find(Agendamento.class, id);
    }

    @Override
    public List<Agendamento> listarTodos() {
        Query query = entityManager.createQuery("SELECT a FROM Agendamento a");
        return query.getResultList();
    }

    @Override
    public List<Agendamento> listarPorPet(Long petId) {
        Query query = entityManager.createQuery("SELECT a FROM Agendamento a WHERE a.pet.id = :petId");
        query.setParameter("petId", petId);
        return query.getResultList();
    }

    @Override
    public List<Agendamento> listarPorData(Date data) {
        Query query = entityManager.createQuery("SELECT a FROM Agendamento a WHERE DATE(a.dataHora) = :data");
        query.setParameter("data", data);
        return query.getResultList();
    }

    @Override
    public List<Agendamento> listarPorStatus(StatusAgendamento status) {
        Query query = entityManager.createQuery("SELECT a FROM Agendamento a WHERE a.status = :status");
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public void salvar(Agendamento agendamento) {
        entityManager.getTransaction().begin();
        entityManager.persist(agendamento);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Agendamento agendamento) {
        entityManager.getTransaction().begin();
        entityManager.merge(agendamento);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Agendamento agendamento) {
        entityManager.getTransaction().begin();
        entityManager.remove(agendamento);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean verificarDisponibilidade(Date dataHora, int duracaoMinutos) {
        Query query = entityManager.createQuery(
            "SELECT COUNT(a) FROM Agendamento a WHERE a.dataHora BETWEEN :inicio AND :fim"
        );
        query.setParameter("inicio", dataHora);
        query.setParameter("fim", new Date(dataHora.getTime() + duracaoMinutos * 60000));
        Long count = (Long) query.getSingleResult();
        return count == 0;
    }
}