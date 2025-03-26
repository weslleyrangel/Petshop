package com.petshop.controller;

import com.petshop.dao.UsuarioDAO;
import com.petshop.dao.UsuarioDAOImpl;
import com.petshop.model.Usuario;

import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public void adicionarUsuario(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioDAO.buscarPorId(id);
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        usuarioDAO.excluir(usuario);
    }

    public boolean autenticar(String email, String senha) {
        return usuarioDAO.autenticar(email, senha);
    }
}