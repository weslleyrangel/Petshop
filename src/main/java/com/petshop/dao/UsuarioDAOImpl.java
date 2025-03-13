package com.petshop.dao;

import com.petshop.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private EntityManager entityManager;

    public UsuarioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
            query.setParameter("email", email);
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        Query query = entityManager.createQuery("SELECT u FROM Usuario u");
        return query.getResultList();
    }

    @Override
    public void salvar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    @Override
    public void atualizar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }

    @Override
    public void excluir(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean autenticar(String email, String senha) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            return query.getSingleResult() != null;
        } catch (NoResultException e) {
            return false;
        }
    }
}