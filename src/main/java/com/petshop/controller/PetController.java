package com.petshop.controller;

import com.petshop.dao.PetDAO;
import com.petshop.dao.PetDAOImpl;
import com.petshop.model.Pet;

import java.util.List;

public class PetController {
    private PetDAO petDAO = new PetDAOImpl();

    public void adicionarPet(Pet pet) {
        petDAO.salvar(pet);
    }

    public List<Pet> listarPets() {
        return petDAO.listarTodos();
    }

    public Pet buscarPetPorId(Long id) {
        return petDAO.buscarPorId(id);
    }

    public void atualizarPet(Pet pet) {
        petDAO.atualizar(pet);
    }

    public void excluirPet(Pet pet) {
        petDAO.excluir(pet);
    }
}