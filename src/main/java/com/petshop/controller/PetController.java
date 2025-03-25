package com.petshop.controller;

import com.petshop.dao.PetDAO;
import com.petshop.dao.PetDAOImpl;
import com.petshop.model.Pet;

import java.util.List;

public class PetController {
    private PetDAO petDAO;

    public PetController(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    public Pet buscarPorId(Long id) {
        return petDAO.buscarPorId(id);
    }

    public List<Pet> listarTodos() {
        return petDAO.listarTodos();
    }

    public void salvar(Pet pet) {
        petDAO.salvar(pet);
    }

    public void atualizar(Pet pet) {
        petDAO.atualizar(pet);
    }

    public void excluir(Pet pet) {
        petDAO.excluir(pet);
    }
}