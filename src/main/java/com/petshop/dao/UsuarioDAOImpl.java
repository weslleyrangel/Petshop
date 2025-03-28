package com.petshop.dao;

import com.petshop.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(usuario -> usuario.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        int index = usuarios.indexOf(buscarPorId(usuario.getId()));
        if (index != -1) {
            usuarios.set(index, usuario);
        }
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
    }

   @Override
    public boolean autenticar(String email, String senha) {
    return usuarios.stream()
            .anyMatch(usuario -> usuario.getEmail().equals(email) && usuario.getSenha().equals(senha));
}
}