package com.petshop.controller;

import com.petshop.dao.PetDAO; // Supondo que você tenha um DAO para pets
import com.petshop.model.Pet;
import java.util.List;

public class PetController {
    private PetDAO petDAO;

    public PetController(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    public void adicionarPet(Pet pet) {
        petDAO.salvar(pet);
    }

    public List<Pet> listarPets() {
        return petDAO.listarTodos();
    }

    public int contarTotalPets() {
        return petDAO.listarTodos().size();
    }

    public Pet buscarPorNome(String nome) {
        // Implementar a lógica para buscar um pet pelo nome
        return petDAO.listarTodos().stream()
                .filter(pet -> pet.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}