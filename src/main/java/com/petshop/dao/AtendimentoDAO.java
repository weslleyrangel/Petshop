package com.petshop.dao;

import com.petshop.model.Atendimento;
import java.util.List;

public interface AtendimentoDAO {
    Atendimento buscarPorId(Long id);
    List<Atendimento> listarTodos();
    List<Atendimento> listarPorPet(Long petId);
    void salvar(Atendimento atendimento);
    void atualizar(Atendimento atendimento);
    void excluir(Atendimento atendimento);
}