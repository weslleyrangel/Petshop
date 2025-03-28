package com.petshop;

import com.petshop.dao.UsuarioDAOImpl;
import com.petshop.dao.PetDAOImpl; // Supondo que você tenha um DAO para pets
import com.petshop.model.TipoUsuario;
import com.petshop.model.Usuario;
import com.petshop.view.TelaLogin;
import com.petshop.controller.UsuarioController;
import com.petshop.controller.PetController;
import com.petshop.model.Pet;

public class Petshop {
    private static UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
    private static PetDAOImpl petDAO = new PetDAOImpl(); // Supondo que você tenha um DAO para pets
    private static UsuarioController usuarioController = new UsuarioController(usuarioDAO);
    private static PetController petController = new PetController(petDAO);

    public static void main(String[] args) {
        inicializarUsuarios();
        inicializarPets(); // Inicializa os pets, se necessário

        // Inicia a tela de login
        new TelaLogin(usuarioDAO, petController).setVisible(true); // Passa o DAO e o PetController para a tela de login
    }

    private static void inicializarUsuarios() {
        // Adicionando usuários para teste
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("Admin");
        usuario1.setEmail("admin@example.com");
        usuario1.setSenha("admin123");
        usuario1.setTipo(TipoUsuario.ADMINISTRADOR);
        usuarioDAO.salvar(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("Operador");
        usuario2.setEmail("operador@example.com");
        usuario2.setSenha("operador123");
        usuario2.setTipo(TipoUsuario.OPERADOR);
        usuarioDAO.salvar(usuario2);
    }

    private static void inicializarPets() {
        Pet pet1 = new Pet(null, "Rex", "Cachorro", "Labrador", 3, 25.0);
        Pet pet2 = new Pet(null, "Miau", "Gato", "Siamês", 2, 5.0);

        petController.adicionarPet(pet1);
        petController.adicionarPet(pet2);
}
    
    }
