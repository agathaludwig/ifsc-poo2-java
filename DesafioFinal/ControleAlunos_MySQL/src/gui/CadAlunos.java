/*
 * CadAlunos.java
 *
 * Created on 15 de Maio de 2008, 21:25
 */

package gui;

import conexao.Conexao;
import dao.AlunoDAO;
import exceptions.ExceptionBD;
import javax.swing.JOptionPane;
import model.Aluno;

/**
 
 @author  Java
 */
public class CadAlunos extends javax.swing.JFrame {
    AlunoDAO dao = new AlunoDAO();  
    /** Creates new form CadAlunos */
    public CadAlunos() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        tfCPF = new javax.swing.JTextField();
        tfRenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Endereço:");

        tfEndereco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btAtualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAtualizar.setText("Alterar");
        btAtualizar.setEnabled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        tfCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tfRenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Renda:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(btPesquisar))
                        .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvar)
                        .addGap(30, 30, 30)
                        .addComponent(btAtualizar)
                        .addGap(29, 29, 29)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFechar)
                        .addGap(18, 18, 18)
                        .addComponent(btLimpar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfRenda, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jLabel3)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btAtualizar)
                    .addComponent(btExcluir)
                    .addComponent(btFechar)
                    .addComponent(btLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Aluno a = new Aluno();
        a.setMatricula(Integer.parseInt(
                tfMatricula.getText()));
        a.setNome(tfNome.getText());
        a.setEndereco(tfEndereco.getText());
        a.setCpf(tfCPF.getText());
        a.setRenda(Double.parseDouble(tfRenda.getText()));
        try {
            dao.inserir(a);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar aluno.\n" + ex.getMessage());
        }
        limparCampos();
        
}//GEN-LAST:event_btSalvarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            int m = Integer.parseInt(tfMatricula.getText());
            Aluno a = dao.getAlunoPorId(m);
                if (a == null) {
                    JOptionPane.showMessageDialog(this, "Aluno não localizado");
                }
                else {
                    tfMatricula.setText(Integer.toString(a.getMatricula()));
                    tfNome.setText(a.getNome());
                    tfEndereco.setText(a.getEndereco());
                    tfCPF.setText(a.getCpf());
                    tfRenda.setText(Double.toString(a.getRenda()));
                    btAtualizar.setEnabled(true);
                }
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar aluno.\n" + ex.getMessage());
        }
        
}//GEN-LAST:event_btPesquisarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Conexao.encerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        Aluno a = new Aluno();
        a.setMatricula(Integer.parseInt(tfMatricula.getText()));
        a.setNome(tfNome.getText());
        a.setEndereco(tfEndereco.getText());
        a.setCpf(tfCPF.getText());
        a.setRenda(Double.parseDouble(tfRenda.getText()));
        try {
            dao.atualizar(a);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar cadastro de aluno.\n" + ex.getMessage());
        }
        limparCampos();
}//GEN-LAST:event_btAtualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int matricula = Integer.parseInt(tfMatricula.getText());
        Aluno a = new Aluno();
        a.setMatricula(matricula);
        try {
            dao.remover(a);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao remover aluno.\n" + ex.getMessage());
        }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfRenda;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        tfMatricula.setText(null);
        tfNome.setText(null);
        tfEndereco.setText(null);
        tfCPF.setText(null);
        tfRenda.setText(null);
        btAtualizar.setEnabled(false);
        tfMatricula.requestFocus();
    }
    
}