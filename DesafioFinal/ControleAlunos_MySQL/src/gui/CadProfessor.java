/*
 * CadAlunos.java
 *
 * Created on 15 de Maio de 2008, 21:25
 */

package gui;

import conexao.Conexao;
import dao.ProfessorDAO;
import exceptions.ExceptionBD;
import gui.table.ProfessorColumnModel;
import gui.table.ProfessorTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import model.EnumTitulacao;
import model.Professor;

/**
 
 @author  Java
 */
public class CadProfessor extends javax.swing.JFrame {
    ProfessorDAO dao = new ProfessorDAO(); 
    Professor p = new Professor();
    ArrayList<Professor> professores = new ArrayList<>() ; 

    /** Creates new form CadAlunos */
    public CadProfessor() {
        try {
            professores = dao.findAll();
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar professor no cadastro\n" + ex.getMessage());
        }
        
        initComponents();
        showList();
        jTableProfessor.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = jTableProfessor.getFontMetrics(jTableProfessor.getFont());
        jTableProfessor.setColumnModel(new ProfessorColumnModel(fm));
        //this.setLocationRelativeTo(parent);
    }
    
    /** This method is called from within the constructor to
     initialize the form.
     WARNING: Do NOT modify this code. The content of this method is
     always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        tfSalario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        cbTitulacao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfessor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Matrícula:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        tfMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btPesquisar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAtualizar.setText("Alterar");
        btAtualizar.setEnabled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        tfSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Titulação");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Salário: R$");

        btExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btFechar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        cbTitulacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graduação", "Especialização", "Mestrado", "Doutorado" }));

        jTableProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Titulação", "Salário"
            }
        ));
        jScrollPane1.setViewportView(jTableProfessor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFechar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimpar)
                                .addGap(0, 52, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(cbTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4)))
                                    .addComponent(jLabel2)
                                    .addComponent(tfNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(cbTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btAtualizar)
                    .addComponent(btExcluir)
                    .addComponent(btFechar)
                    .addComponent(btLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        p.setMatricula(Integer.parseInt(tfMatricula.getText()));
        p.setNome(tfNome.getText());
        //p.setTitulacao(EnumTitulacao.valueOf(cbTitulacao.getSelectedItem().toString()));
        p.setTitulacao(cbTitulacao.getSelectedItem().toString());
        p.setSalario(Double.parseDouble(tfSalario.getText()));
        try {
            dao.inserir(p);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar professor no cadastro\n" + ex.getMessage());
        }
        limparCampos();
        showList();
        
}//GEN-LAST:event_btSalvarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            int m = Integer.parseInt(tfMatricula.getText());
            Professor p = dao.getProfessorPorId(m);
                if (p == null) {
                    JOptionPane.showMessageDialog(this, "Professor não localizado");
                }
                else {
                    tfMatricula.setText(Integer.toString(p.getMatricula()));
                    tfNome.setText(p.getNome());
                    cbTitulacao.setSelectedItem(p.getTitulacao());
                    tfSalario.setText(Double.toString(p.getSalario()));
                    btAtualizar.setEnabled(true);
                }
            
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar professor no cadastro.\n" + ex.getMessage());
        }
        
}//GEN-LAST:event_btPesquisarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Conexao.encerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        p.setMatricula(Integer.parseInt(tfMatricula.getText()));
        p.setNome(tfNome.getText());
        p.setSalario(Double.parseDouble(tfSalario.getText()));
        //p.setTitulacao(EnumTitulacao.valueOf(cbTitulacao.getSelectedItem().toString()));
         p.setTitulacao(cbTitulacao.getSelectedItem().toString());
        try {
            dao.atualizar(p);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar professor no cadastro\n" + ex.getMessage());
        }
        showList();
        limparCampos();
}//GEN-LAST:event_btAtualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int matricula = Integer.parseInt(tfMatricula.getText());
        p.setMatricula(matricula);
        try {
            dao.remover(p);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao remover professor do cadastro\n" + ex.getMessage());
        }
        showList();
        limparCampos();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
        //new Menu().setVisible(true);
    }//GEN-LAST:event_btFecharActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCampos();
        btAtualizar.setEnabled(false);
    }//GEN-LAST:event_btLimparActionPerformed
    
    /**
     @param args the command line arguments
     */
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<Object> cbTitulacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfessor;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSalario;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        tfMatricula.setText(null);
        tfNome.setText(null);
        tfSalario.setText(null);
        cbTitulacao.setSelectedItem("Graduação");
        
        btAtualizar.setEnabled(false);
        tfMatricula.requestFocus();
    }
    private void showList() {
        try {
            this.setListaProfessores(dao.findAll());
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados do cadastro\n" + ex.getMessage());
        }
    }
    public void setListaProfessores(ArrayList<Professor> professores) {
        this.jTableProfessor.setModel(new ProfessorTableModel(professores));
    }
    
}
