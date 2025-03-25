package com.petshop.dao;

import com.petshop.model.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    private EntityManager entityManager;

    public PetDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Pet buscarPorId(Long id) {
        return entityManager.find(Pet.class, id);
    }

    @Override
    public List<Pet> listarTodos() {
        Query query = entityManager.createQuery("SELECT p FROM Pet p");
        return query.getResultList();
    }

    @Override
    public List<Pet> listarPorCliente(Long clienteId) {
        Query query = entityManager.createQuery("SELECT p FROM Pet p WHERE p.cliente.id = :clienteId");
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    @Override
    public void salvar(Pet pet) {
        entityManager.getTransaction().begin();
        entityManager.persist(pet);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Pet pet) {
        entityManager.getTransaction().begin();
        entityManager.merge(pet);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Pet pet) {
        entityManager.getTransaction().begin();
        entityManager.remove(pet);
        entityManager.getTransaction().commit();
    }
}