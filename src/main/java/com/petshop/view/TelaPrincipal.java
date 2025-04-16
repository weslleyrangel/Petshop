/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.petshop.view;

import com.petshop.controller.AgendamentoController;
import com.petshop.controller.PetController;
import com.petshop.controller.UsuarioController;
import com.petshop.dao.UsuarioDAO;
import com.petshop.model.Agendamento;
import com.petshop.model.TipoUsuario;
import com.petshop.model.Usuario;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author wesll
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private UsuarioController usuarioController;
    private PetController petController;
    private UsuarioDAO usuarioDAO;
    private List<Agendamento> agendamentos; // Lista de agendamentos
    private javax.swing.JFormattedTextField txtDataAgendar;
    private TelaPrincipal TelaPrincipal;
    private AgendamentoController agendamentoController;

 public TelaPrincipal(UsuarioDAO usuarioDAO, PetController petController, AgendamentoController agendamentoController, Usuario usuarioLogado) {
    initComponents();
    this.usuarioDAO = usuarioDAO;
    this.usuarioController = new UsuarioController(usuarioDAO);
    this.petController = petController;
    this.agendamentos = new ArrayList<>();
    this.agendamentoController = agendamentoController;

    
    setPermissoes(usuarioLogado.getTipo());

    try {
        MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
        dateFormatter.setPlaceholderCharacter('_');
        txtDataAgendar = new javax.swing.JFormattedTextField(dateFormatter);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Erro ao formatar a data: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    atualizarTotais();
};
    
    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
        exibirAgendamentos(); 
    }
    
    public void setNomeAdmin(String nome) {
        jbNomeAdmin.setText(nome);
    }
    
    
    
    public void exibirAgendamentos() {
    DefaultTableModel modelo = (DefaultTableModel) tblAgendamentos.getModel();
    modelo.setRowCount(0); 

    for (Agendamento agendamento : agendamentos) {
        modelo.addRow(new Object[]{
            agendamento.getHorario(),
            agendamento.getServico(),
            agendamento.getUsuario().getNome(), 
            agendamento.getPet().getNome(), 
            agendamento.getDataHora()
        });
    }
}
    
     

    public void setPermissoes(TipoUsuario tipo) {
        if (tipo == TipoUsuario.ADMINISTRADOR) {
            btnCadastroDeClientes.setEnabled(true);
            btnCadastroDePet.setEnabled(true);
            btnAgendamentos.setEnabled(true);
            btnProdutos.setEnabled(true);
        } else if (tipo == TipoUsuario.OPERADOR) {
            btnCadastroDeClientes.setEnabled(true);
            btnCadastroDePet.setEnabled(true);
            btnAgendamentos.setEnabled(true);
            btnProdutos.setEnabled(false);
        } 
    }

    public void atualizarTotais() {
         if (usuarioController != null && petController != null) {
            int totalClientes = usuarioController.contarTotalUsuarios();
            jbTotalClientes.setText(String.valueOf(totalClientes));

            int totalPets = petController.contarTotalPets();
            jbTotalPets.setText(String.valueOf(totalPets));

            int totalAgendamentos = contarAgendamentosDoDia(); 
            jbAgendamentosDoDia.setText(String.valueOf(totalAgendamentos));
        }
    }
    
    public void atualizarAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos; 
        exibirAgendamentos(); 
        atualizarTotais();
    }
    
    
    private int contarAgendamentosDoDia() {
        int contador = 0;
            Calendar dataAtual = Calendar.getInstance(); 
            dataAtual.set(Calendar.HOUR_OF_DAY, 0);
            dataAtual.set(Calendar.MINUTE, 0);
            dataAtual.set(Calendar.SECOND, 0);
            dataAtual.set(Calendar.MILLISECOND, 0);

        
        for (Agendamento agendamento : agendamentos) {
            Calendar dataAgendamento = Calendar.getInstance();
            dataAgendamento.setTime(agendamento.getDataHora()); 
            dataAgendamento.set(Calendar.HOUR_OF_DAY, 0);
            dataAgendamento.set(Calendar.MINUTE, 0);
            dataAgendamento.set(Calendar.SECOND, 0);
            dataAgendamento.set(Calendar.MILLISECOND, 0);

            
            if (dataAgendamento.equals(dataAtual)) {
                contador++; 
            }
        }
            return contador;
        }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbNomeAdmin = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jbTotalClientes = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jbTotalPets = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jbAgendamentosDoDia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnCadastroDeClientes = new javax.swing.JButton();
        btnCadastroDePet = new javax.swing.JButton();
        btnAgendamentos = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        btnTelaPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(80, 161, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PETSHOP");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seja bem-vindo(a),");

        jbNomeAdmin.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbNomeAdmin.setForeground(new java.awt.Color(0, 245, 0));

        btnSair.setBackground(new java.awt.Color(255, 123, 123));
        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jbNomeAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jbNomeAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(80, 161, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total de Clientes");

        jbTotalClientes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbTotalClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbTotalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbTotalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(80, 161, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(136, 62));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total de Pets");

        jbTotalPets.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbTotalPets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTotalPets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbTotalPets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(80, 161, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(136, 62));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Agendamentos do dia");

        jbAgendamentosDoDia.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbAgendamentosDoDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbAgendamentosDoDia.setPreferredSize(new java.awt.Dimension(38, 19));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAgendamentosDoDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgendamentosDoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblAgendamentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Horário", "Serviço", "Cliente", "Pet", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAgendamentos);
        if (tblAgendamentos.getColumnModel().getColumnCount() > 0) {
            tblAgendamentos.getColumnModel().getColumn(0).setResizable(false);
            tblAgendamentos.getColumnModel().getColumn(1).setResizable(false);
            tblAgendamentos.getColumnModel().getColumn(2).setResizable(false);
            tblAgendamentos.getColumnModel().getColumn(3).setResizable(false);
            tblAgendamentos.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel8.setBackground(new java.awt.Color(180, 215, 255));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Proxímos Agendamentos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(241, 241, 241));

        btnCadastroDeClientes.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnCadastroDeClientes.setText("Cadastro de Cliente");
        btnCadastroDeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroDeClientesActionPerformed(evt);
            }
        });

        btnCadastroDePet.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnCadastroDePet.setText("Cadastro de Pet");
        btnCadastroDePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroDePetActionPerformed(evt);
            }
        });

        btnAgendamentos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnAgendamentos.setText("Agendamentos");
        btnAgendamentos.setPreferredSize(new java.awt.Dimension(78, 23));
        btnAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentosActionPerformed(evt);
            }
        });

        btnProdutos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnTelaPrincipal.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnTelaPrincipal.setText("Tela Principal");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastroDePet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgendamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroDeClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(btnTelaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCadastroDeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCadastroDePet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       int resposta = JOptionPane.showConfirmDialog(this, "Você tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
        new TelaLogin(usuarioDAO, petController, agendamentoController).setVisible(true); 
        dispose();
    }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastroDeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroDeClientesActionPerformed
        new TelaCadastroDeCliente(usuarioDAO, petController, agendamentoController, usuarioController).setVisible(true); 
        dispose(); // Fecha a tela 
    }//GEN-LAST:event_btnCadastroDeClientesActionPerformed

    private void btnAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentosActionPerformed
        try {
        new TelaAgendamentos(usuarioDAO, petController, this, agendamentoController, usuarioController).setVisible(true);
        dispose(); 
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir a tela de agendamentos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgendamentosActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        new TelaProdutosLista(usuarioDAO, petController,agendamentoController, usuarioController).setVisible(true); // Abre a tela de agendamentos
        dispose(); // Fecha a tela 
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnCadastroDePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroDePetActionPerformed
        new TelaCadastrarPet(usuarioDAO, petController, agendamentoController, usuarioController).setVisible(true);
        dispose(); // Fecha a tela atual
    }//GEN-LAST:event_btnCadastroDePetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendamentos;
    private javax.swing.JButton btnCadastroDeClientes;
    private javax.swing.JButton btnCadastroDePet;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTelaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbAgendamentosDoDia;
    private javax.swing.JLabel jbNomeAdmin;
    private javax.swing.JLabel jbTotalClientes;
    private javax.swing.JLabel jbTotalPets;
    private javax.swing.JTable tblAgendamentos;
    // End of variables declaration//GEN-END:variables
}
