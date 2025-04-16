package com.petshop.dao;

import com.petshop.model.Pet;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    private List<Pet> pets = new ArrayList<>();

    @Override
    public Pet buscarPorId(Long id) {
        return pets.stream()
                .filter(pet -> pet.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Pet> listarTodos() {
        return new ArrayList<>(pets);
    }

    @Override
    public List<Pet> listarPorCliente(Long clienteId) {
        List<Pet> result = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getCliente() != null && pet.getCliente().getId().equals(clienteId)) {
                result.add(pet);
            }
        }
        return result;
    }

    @Override
    public void salvar(Pet pet) {
        pets.add(pet);
    }

    @Override
    public void atualizar(Pet pet) {
        int index = pets.indexOf(buscarPorId(pet.getId()));
        if (index != -1) {
            pets.set(index, pet);
        }
    }

    @Override
    public void excluir(Pet pet) {
        pets.removeIf(p -> p.getId().equals(pet.getId()));
    }
}