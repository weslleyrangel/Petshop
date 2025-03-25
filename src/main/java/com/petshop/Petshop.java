package com.petshop;

import com.formdev.flatlaf.FlatLightLaf; // Importando o FlatLaf
import com.petshop.view.TelaLogin;
import javax.swing.UIManager; // Importando UIManager para definir o Look and Feel
import javax.swing.UnsupportedLookAndFeelException; // Importando a exceção

/**
 *
 * @author wesll
 */
public class Petshop {

    public static void main(String[] args) {
        // Definindo o Look and Feel para FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Criando e exibindo a tela de login
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}