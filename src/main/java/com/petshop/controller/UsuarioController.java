package com.petshop.controller;

import com.petshop.dao.UsuarioDAO;
import com.petshop.model.Usuario;

import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario buscarPorId(Long id) {
        return usuarioDAO.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioDAO.listarTodos();
    }

    public void salvar(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    public void atualizar(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    public void excluir(Usuario usuario) {
        usuarioDAO.excluir(usuario);
    }
}