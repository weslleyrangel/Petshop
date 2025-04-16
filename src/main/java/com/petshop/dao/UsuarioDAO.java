package com.petshop.dao;

import com.petshop.model.Agendamento;
import com.petshop.model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    Usuario buscarPorId(Long id);
    Usuario buscarPorEmail(String email);
    List<Agendamento> listarAgendamentosPorUsuario(Usuario usuario);
    List<Usuario> listarTodos();
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void excluir(Usuario usuario);
    boolean autenticar(String email, String senha);
}