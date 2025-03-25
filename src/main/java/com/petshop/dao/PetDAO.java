package com.petshop.dao;

import com.petshop.model.Pet;
import java.util.List;

public interface PetDAO {
    Pet buscarPorId(Long id);
    List<Pet> listarTodos();
    List<Pet> listarPorCliente(Long clienteId);
    void salvar(Pet pet);
    void atualizar(Pet pet);
    void excluir(Pet pet);
}