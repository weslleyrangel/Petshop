package com.petshop.dao;

import java.util.List;

import com.petshop.model.Pet;

public interface PetDAO {
    Pet buscarPorId(Long id);
    List<Pet> listarTodos();
    List<Pet> listarPorCliente(Long clienteId);
    void salvar(Pet pet);
    void atualizar(Pet pet);
    void excluir(Pet pet);
}