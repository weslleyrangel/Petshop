package com.petshop.controller;

import com.petshop.dao.UsuarioDAO;
import com.petshop.model.Usuario;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

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
        Usuario usuario = usuarioDAO.buscarPorEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioDAO.buscarPorEmail(email);
    }
    
   public Usuario buscarUsuarioPorNome(String nome) {
    for (Usuario usuario : usuarioDAO.listarTodos()) {
        if (usuario.getNome().equalsIgnoreCase(nome)) {
            return usuario; 
            }
        }
        return null; 
    }
    
    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public int contarTotalUsuarios() {
        return usuarioDAO.listarTodos().size();
    }
}