/*
 * CadastroSetor.java
 *
 * Created on 12 de Março de 2006, 10:52
 */

package net.softlages.gui;
import net.softlages.gui.tablecfg.SetorTableModel;
import net.softlages.gui.tablecfg.SetorColumnModel;
import java.util.*;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import net.softlages.exception.SetorException;
import net.softlages.vo.*;
import net.softlages.dao.*;
import net.softlages.db.*;

/**
 *
 * @author  Cliente
 */
public class CadastroSetor extends javax.swing.JDialog {
    
    private Setor setor;
    private List<Setor> listaSetores;
    private boolean novoSetor;
    private SetorDAO setorDAO;
    
    public CadastroSetor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setor = new Setor();
        Conexao.conectar();
        setorDAO = new SetorDAO();
        
        try {
            listaSetores = setorDAO.findAll(Conexao.getCon());
        } catch (SetorException se) {
            JOptionPane.showMessageDialog(this,"Não há setores cadastrados.");
        }
        initComponents();
        if (listaSetores == null) {
            listaSetores = new ArrayList<Setor>();
        }
        this.setListaSetores(listaSetores);
        setores.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = setores.getFontMetrics(setores.getFont());
        setores.setColumnModel(new SetorColumnModel(fm));
        
        this.setLocationRelativeTo(parent);
    }
    
    private void showList() {
        try {
            this.setListaSetores(setorDAO.findAll(Conexao.getCon()));
        } catch (SetorException se) {
            JOptionPane.showMessageDialog(this,"Error ao carregar os dados", "Erro de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void addActionListener(ActionListener listener) {

    }
    
    public void removeActionListener(ActionListener listener) {

    }
    
    private void tratarBotoes() {
        jbInserir.setEnabled(!jbInserir.isEnabled());
        //   jbEditar.setEnabled(!jbEditar.isEnabled());
        jbRemover.setEnabled(!jbRemover.isEnabled());
        jbCancelar.setEnabled(!jbCancelar.isEnabled());
        jbConfirmar.setEnabled(!jbConfirmar.isEnabled());
        jbFechar.setEnabled(!jbFechar.isEnabled());
    }
    
    public void setNovoSetor(boolean novoSetor) {
        this.novoSetor = novoSetor;
        jbRemover.setEnabled(!novoSetor);
        if (isNovoSetor())
            setMensagem("Forneça os dados para o novo setor.", false);
        else
            setMensagem("Alterando os dados do setor", false);
    }
    
    public boolean isNovoSetor() {
        return novoSetor;
    }
    
    public void setSetor(Setor setor) {
        this.setor = setor;
        jtfCodigo.setText(Integer.toString(setor.getCodigo()));
        jtfNome.setText(setor.getNome());
        jtfLocal.setText(setor.getLocal());
    }
    
    public Setor getSetor() {
        if (!jbInserir.isEnabled())
            setor.setCodigo(Integer.parseInt(jtfCodigo.getText()));
        setor.setNome(jtfNome.getText());
        setor.setLocal(jtfLocal.getText());
        return setor;
    }
    
    private void habilitaEdicao(boolean habilitado) {
        jbEditar.setEnabled(habilitado);
    }
    
  
    private void habilitaRemocao(boolean habilitado) {
        jbRemover.setEnabled(habilitado);
    }
    
    
    private ListSelectionListener selectionListener =
            new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
        }
    };
    
    public void setMensagem(String msg, boolean isErro) {
        status.setText(msg);
        if (isErro)
            status.setForeground(Color.RED);
        else
            status.setForeground(Color.DARK_GRAY);
    }
    
    private SetorTableModel getSetorTableModel() {
        return (SetorTableModel)setores.getModel();
    }
    
    public void setListaSetores(java.util.List<Setor> setores) {
        this.setores.setModel(new SetorTableModel(setores));
    }
    
    public Setor getSetorSelecionado() {
        return ((SetorTableModel)setores.getModel()).getValoresSetor(setores.getSelectedRow());
    }
    
    public Setor[] getSetoresSelecionados() {
        Setor[] selecao = new Setor[setores.getSelectedRowCount()];
        int[] indices = setores.getSelectedRows();
        int j = 0;
        for (int i : indices)
            selecao[j++] = ((SetorTableModel)setores.getModel()).getValoresSetor(i);
        return selecao;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfLocal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jbInserir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        setores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        status = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manuten\u00e7\u00e3o do Cadastro de Setor");
        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Forne\u00e7a os Dados do Setor");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 347;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setDisplayedMnemonic('d');
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setLabelFor(jtfCodigo);
        jLabel2.setText("C\u00f3digo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setDisplayedMnemonic('o');
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setLabelFor(jtfNome);
        jLabel3.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setDisplayedMnemonic('l');
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setLabelFor(jtfLocal);
        jLabel4.setText("Local:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel4, gridBagConstraints);

        jtfCodigo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jtfCodigo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 379;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jtfNome, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 379;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jtfLocal, gridBagConstraints);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 480;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jSeparator1, gridBagConstraints);

        jbInserir.setMnemonic('I');
        jbInserir.setText("Inserir");
        jbInserir.setActionCommand("inserirSetor");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jPanel1.add(jbInserir);

        jbEditar.setMnemonic('E');
        jbEditar.setText("Editar");
        jbEditar.setActionCommand("editarSetor");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jPanel1.add(jbEditar);

        jbRemover.setMnemonic('R');
        jbRemover.setText("Remover");
        jbRemover.setActionCommand("removerSetor");
        jbRemover.setEnabled(false);
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jPanel1.add(jbRemover);

        jbConfirmar.setMnemonic('C');
        jbConfirmar.setText("Confirmar");
        jbConfirmar.setActionCommand("confirmarSetor");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jPanel1.add(jbConfirmar);

        jbCancelar.setMnemonic('a');
        jbCancelar.setText("Cancelar");
        jbCancelar.setActionCommand("cancelarSetor");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jPanel1.add(jbCancelar);

        jbFechar.setMnemonic('F');
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jPanel1.add(jbFechar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 480;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jSeparator2, gridBagConstraints);

        setores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Financeiro", "Bloco A"},
                {"2", "Administrativo", "Bloco A"},
                {"3", "NIU", "Bloco B"},
                {"4", "Estoque", null}
            },
            new String [] {
                "Código", "Nome", "Local"
            }
        ));
        setores.setVerifyInputWhenFocusTarget(false);
        setores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setoresMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(setores);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = -100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel5.setDisplayedMnemonic('u');
        jLabel5.setLabelFor(jtfPesquisar);
        jLabel5.setText("Pesquisa:");
        jPanel2.add(jLabel5);

        jtfPesquisar.setColumns(35);
        jtfPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfPesquisarFocusGained(evt);
            }
        });
        jtfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisarKeyPressed(evt);
            }
        });

        jPanel2.add(jtfPesquisar);

        jbPesquisar.setMnemonic('P');
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jPanel2.add(jbPesquisar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 325;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        status.setBackground(new java.awt.Color(255, 255, 153));
        status.setFont(new java.awt.Font("Tahoma", 1, 11));
        status.setText("Cadastro de Setor");
        status.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 389;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(status, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jtfPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)
            jbPesquisar.doClick();
    }//GEN-LAST:event_jtfPesquisarKeyPressed
    
    private void jtfPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPesquisarFocusGained
        if (jbInserir.isEnabled())
            tratarBotoes();
    }//GEN-LAST:event_jtfPesquisarFocusGained
    
    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        try {
            this.setListaSetores(setorDAO.findByNome(jtfPesquisar.getText(),Conexao.getCon()));
        } catch (SetorException se) {
            JOptionPane.showMessageDialog(this,"Impossível carregar os dados");
        }
    }//GEN-LAST:event_jbPesquisarActionPerformed
    
    private void setoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setoresMouseClicked
        jbEditar.doClick();
        if (jbInserir.isEnabled())
            tratarBotoes();
    }//GEN-LAST:event_setoresMouseClicked
    
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limparCampos();
        showList();
        tratarBotoes();
    }//GEN-LAST:event_jbCancelarActionPerformed
    
    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        Setor setor = this.getSetor();
        try {
            setorDAO.update(setor.getCodigo(),setor,Conexao.getCon());
        }catch (SetorException se) {
            JOptionPane.showMessageDialog(this,"Erro ao alterar os dados\n" + se.getMessage(), "Erro de consulta", JOptionPane.ERROR_MESSAGE);
        }
        
        limparCampos();
        showList();
        tratarBotoes();
    }//GEN-LAST:event_jbConfirmarActionPerformed
    
    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        Setor[] setores = this.getSetoresSelecionados();
        int removidos = 0;
        for (Setor setor : setores) {
            int resposta = javax.swing.JOptionPane.showConfirmDialog(this,
                    "Tem certeza de que deseja remover" +
                    " o setor\n[" + setor.getNome() + "] ?",
                    "Remover Tarefas",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    setorDAO.delete(setor.getCodigo(),Conexao.getCon());
                } catch (SetorException se) {
                    JOptionPane.showMessageDialog(this,"Erro ao remover os dados\n" + se.getMessage(), "Erro de consulta", JOptionPane.ERROR_MESSAGE);
                }
                removidos++;
            }
        }
        if (removidos > 0) {
            showList();
        }
        
        limparCampos();
        tratarBotoes();
    }//GEN-LAST:event_jbRemoverActionPerformed
    
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        this.setSetor(this.getSetorSelecionado());
        tratarBotoes();
    }//GEN-LAST:event_jbEditarActionPerformed
    
    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        //Conexao.encerrar();
        this.dispose();
    }//GEN-LAST:event_jbFecharActionPerformed
    
    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        setor = this.getSetor();
        try {
            setorDAO.insert(setor,Conexao.getCon());
            showList();
        } catch (SetorException se) {
            JOptionPane.showMessageDialog(this,"Erro ao inserir os dados\n" + se.getMessage(), "Erro de consulta", JOptionPane.ERROR_MESSAGE);
        }
        limparCampos();
    }//GEN-LAST:event_jbInserirActionPerformed
    
    private void limparCampos() {
        jtfCodigo.setText("");
        jtfNome.setText("");
        jtfLocal.setText("");
        this.setor = new Setor();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroSetor(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfLocal;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPesquisar;
    private javax.swing.JTable setores;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
