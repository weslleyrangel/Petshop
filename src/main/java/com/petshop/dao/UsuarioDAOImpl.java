package com.petshop.dao;

import com.petshop.model.Agendamento;
import com.petshop.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDAOImpl implements UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Agendamento> agendamentos = new ArrayList<>(); 

    @Override
    public Usuario buscarPorId(Long id) {
        if (id == null) {
            return null; 
        }
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null; 
        }
        return usuarios.stream()
                .filter(usuario -> usuario.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<Agendamento> listarAgendamentosPorUsuario(Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            return new ArrayList<>(); 
        }
        return agendamentos.stream()
                .filter(agendamento -> agendamento.getUsuario() != null && agendamento.getUsuario().getId().equals(usuario.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void salvar(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            return; 
        }
        int index = usuarios.indexOf(buscarPorId(usuario.getId()));
        if (index != -1) {
            usuarios.set(index, usuario);
        }
    }

    @Override
    public void excluir(Usuario usuario) {
        if (usuario != null && usuario.getId() != null) {
            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
        }
    }

    @Override
    public boolean autenticar(String email, String senha) {
        if (email == null || senha == null) {
            return false; 
        }
        return usuarios.stream()
                .anyMatch(usuario -> usuario.getEmail().equals(email) && usuario.getSenha().equals(senha));
    }

    
    public void adicionarAgendamento(Agendamento agendamento) {
        if (agendamento != null) {
            agendamentos.add(agendamento);
        }
    }
}