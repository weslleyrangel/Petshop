package com.petshop;

import com.petshop.dao.UsuarioDAOImpl;
import com.petshop.dao.PetDAOImpl; 
import com.petshop.dao.AgendamentoDAOImpl; 
import com.petshop.controller.UsuarioController;
import com.petshop.controller.PetController;
import com.petshop.controller.AgendamentoController; 
import com.petshop.model.Usuario;
import com.petshop.model.Administrador;
import com.petshop.model.Funcionario;
import com.petshop.model.Pet;
import com.petshop.model.Agendamento;
import com.petshop.model.StatusAgendamento;
import com.petshop.view.TelaLogin;

import java.util.Date;

public class Petshop {
    private static UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
    private static PetDAOImpl petDAO = new PetDAOImpl(); 
    private static AgendamentoDAOImpl agendamentoDAO = new AgendamentoDAOImpl(); 
    private static UsuarioController usuarioController = new UsuarioController(usuarioDAO);
    private static PetController petController = new PetController(petDAO);
    private static AgendamentoController agendamentoController = new AgendamentoController(agendamentoDAO, usuarioDAO); 

    public static void main(String[] args) {
        inicializarUsuarios();
        inicializarPets(); 
        inicializarAgendamentos(); 
        new TelaLogin(usuarioDAO, petController, agendamentoController).setVisible(true); 
    }

    private static void inicializarUsuarios() {
        
        Administrador admin = new Administrador();
        admin.setId(1L);
        admin.setNome("Admin");
        admin.setEmail("admin@example.com");
        admin.setSenha("admin123");
        admin.setNivelAcesso("Alto");
        usuarioDAO.salvar(admin);

        
        Funcionario operador = new Funcionario();
        operador.setId(2L);
        operador.setNome("Operador");
        operador.setEmail("operador@example.com");
        operador.setSenha("operador123");
        operador.setCargo("Atendente");
        operador.setDataContratacao(new Date());
        usuarioDAO.salvar(operador);

        
        String[] nomes = {"João Silva", "Maria Oliveira", "Pedro Santos"};
        for (int i = 0; i < 3; i++) {
            Usuario usuario = new Usuario();
            usuario.setId((long) (i + 3)); 
            usuario.setNome(nomes[i]);
            usuario.setEmail("cliente" + (i + 1) + "@example.com");
            usuario.setSenha("cliente123");
            usuarioDAO.salvar(usuario);
        }
    }

    private static void inicializarPets() {
        Pet pet1 = new Pet(null, "Rex", "Cachorro", "Labrador", 3, 25.0, "Macho");
        Pet pet2 = new Pet(null, "Miau", "Gato", "Siamês", 2, 5.0, "Fêmea");
        Pet pet3 = new Pet(null, "Bobby", "Cachorro", "Poodle", 4, 10.0, "Macho");
        Pet pet4 = new Pet(null, "Luna", "Gato", "Persa", 1, 4.0, "Fêmea");
        Pet pet5 = new Pet(null, "Fido", "Cachorro", "Beagle", 5, 20.0, "Macho");

        // Associar pets a clientes
        pet1.setCliente((Usuario) usuarioDAO.buscarPorId(3L)); // Cliente 1
        pet2.setCliente((Usuario) usuarioDAO.buscarPorId(4L)); // Cliente 2
        pet3.setCliente((Usuario) usuarioDAO.buscarPorId(5L)); // Cliente 3
        pet4.setCliente((Usuario) usuarioDAO.buscarPorId(3L)); // Cliente 1
        pet5.setCliente((Usuario) usuarioDAO.buscarPorId(4L)); // Cliente 2

        petController.adicionarPet(pet1);
        petController.adicionarPet(pet2);
        petController.adicionarPet(pet3);
        petController.adicionarPet(pet4);
        petController.adicionarPet(pet5);
    }

    private static void inicializarAgendamentos() {
        for (int i = 1; i <= 5; i++) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId((long) i);
            agendamento.setUsuario((Usuario) usuarioDAO.buscarPorId((long) (i + 2))); // Ajuste conforme necessário
            agendamento.setPet(petController.listarTodos().get(i - 1)); 
            agendamento.setDataHora(new Date()); 
            agendamento.setServico("Serviço " + i);
            agendamento.setHorario("10:00");
            agendamento.setStatus(StatusAgendamento.PENDENTE); 

            agendamentoController.salvar(agendamento);
        }
    }
}