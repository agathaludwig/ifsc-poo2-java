/*
 * CadastroFuncionario.java
 *
 * Created on 19 de Outubro de 2006, 17:51
 */

package net.softlages.gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import net.softlages.exception.DependenteException;
import net.softlages.exception.FuncionarioException;
import net.softlages.exception.SetorException;
import net.softlages.vo.*;
import net.softlages.dao.*;
import net.softlages.db.*;

/**
 *
 * @author  java
 */
public class CadastroFuncionario extends javax.swing.JDialog {
    private Setor setor;
    private List<Setor> listaSetores;
    private SetorDAO setorDAO;
    
    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    
    private Dependente dependente;
    // private List<Dependente> listaDependentes;
    private DependenteDAO dependenteDAO;
    
    private int dep_codigo;
    
    /** Creates new form CadastroFuncionario */
    public CadastroFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.funcionario = new Funcionario();
        this.dependente = new Dependente();
        initComponents();
        estabelecerConexaoBD();
        listaSetores = carregarDadosSetor();
        
        
        // define mascara para os campo dataNasc, dataNascDEP, CPF
        FormatValues.formatDate(this.ftfDataNasc);
        FormatValues.formatCPF(this.ftfCPF);
        FormatValues.formatPhoneNumber(this.ftfCelular);
        FormatValues.formatPhoneNumber(this.ftfFone);
        
        
        this.ftfSalario.setDocument(new MyPlainDocumentForCurrency());
        //FormatValues.formatCurrency(this.ftfSalario);
        //listaDependentes = new ArrayList<Dependente>();
        
        this.setLocationRelativeTo(parent);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfObs = new javax.swing.JTextArea();
        comboBoxSetores = new javax.swing.JComboBox();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jbPesquisar = new javax.swing.JButton();
        ftfDataNasc = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        tfEMail = new javax.swing.JTextField();
        ftfCPF = new javax.swing.JFormattedTextField();
        ftfFone = new javax.swing.JFormattedTextField();
        ftfCelular = new javax.swing.JFormattedTextField();
        ftfSalario = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbInserir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manuten��o do Cadastro de Funcion�rios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Dados do Funcion�rio");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("C�digo:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Fone:");

        jLabel5.setText("CPF:");

        jLabel6.setText("Data Nascimento:");

        jLabel7.setText("Sexo:");

        jLabel8.setText("Celular:");

        jLabel9.setText("Sal�rio:");

        jLabel10.setText("Observa��es:");

        jLabel11.setText("Setor:");

        tfCodigo.setEditable(false);

        tfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNomeFocusLost(evt);
            }
        });

        tfObs.setColumns(20);
        tfObs.setRows(5);
        jScrollPane1.setViewportView(tfObs);

        comboBoxSetores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(rbMasculino);
        rbMasculino.setSelected(true);
        rbMasculino.setText("Masculino");
        rbMasculino.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rbMasculino.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(rbFeminino);
        rbFeminino.setText("Feminino");
        rbFeminino.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rbFeminino.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        ftfDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataNascFocusLost(evt);
            }
        });

        jLabel12.setText("E-mail:");

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jLabel2)
                                .add(jLabel3)
                                .add(jLabel5)
                                .add(jLabel4)
                                .add(jLabel12))
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jLabel7)
                                .add(jLabel9)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(tfCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jbPesquisar))
                            .add(tfNome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(tfEMail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                        .add(17, 17, 17))
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(ftfCPF)
                                            .add(ftfFone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                                        .add(46, 46, 46)
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(jLabel6)
                                            .add(jLabel8))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(ftfCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(ftfDataNasc, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                                .add(17, 17, 17))
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, ftfSalario)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                    .add(10, 10, 10)
                                    .add(rbMasculino)
                                    .add(31, 31, 31)
                                    .add(rbFeminino)))))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel10)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel11)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboBoxSetores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 435, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jButton1)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(tfCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbPesquisar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(tfNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(ftfCPF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(ftfFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel8)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(ftfDataNasc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ftfCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(6, 6, 6)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(tfEMail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(rbMasculino)
                    .add(rbFeminino))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(ftfSalario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel10)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(7, 7, 7)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(comboBoxSetores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbInserir.setMnemonic('I');
        jbInserir.setText("Inserir");
        jbInserir.setActionCommand("inserirSetor");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jbConsultar.setMnemonic('E');
        jbConsultar.setText("Consultar");
        jbConsultar.setActionCommand("editarSetor");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jbRemover.setMnemonic('R');
        jbRemover.setText("Remover");
        jbRemover.setActionCommand("removerSetor");
        jbRemover.setEnabled(false);
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jbConfirmar.setMnemonic('C');
        jbConfirmar.setText("Confirmar");
        jbConfirmar.setActionCommand("confirmarSetor");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbCancelar.setMnemonic('a');
        jbCancelar.setText("Cancelar");
        jbCancelar.setActionCommand("cancelarSetor");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbFechar.setMnemonic('F');
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jbInserir)
                .add(15, 15, 15)
                .add(jbConsultar)
                .add(22, 22, 22)
                .add(jbRemover)
                .add(19, 19, 19)
                .add(jbConfirmar)
                .add(20, 20, 20)
                .add(jbCancelar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 23, Short.MAX_VALUE)
                .add(jbFechar))
        );

        jPanel2Layout.linkSize(new java.awt.Component[] {jbCancelar, jbConfirmar, jbConsultar, jbFechar, jbInserir, jbRemover}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(jbFechar)
                .add(jbInserir)
                .add(jbConsultar)
                .add(jbRemover)
                .add(jbConfirmar)
                .add(jbCancelar))
        );

        jPanel2Layout.linkSize(new java.awt.Component[] {jbCancelar, jbConfirmar, jbConsultar, jbFechar, jbInserir, jbRemover}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ftfDataNascFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataNascFocusLost
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date dt = new Date();
            dt = sdf.parse(ftfDataNasc.getText());
        } catch (ParseException pe) {
            javax.swing.JOptionPane.showMessageDialog(null,"Data inv�lida");
        }
    }//GEN-LAST:event_ftfDataNascFocusLost
            
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       Conexao.encerrar();
    }//GEN-LAST:event_formWindowClosing
// TODO nao permitir insercao de dependentes se dados nao foram preenchidos corretamente                                    
    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        int id;
        try {
            id = Integer.parseInt(
                    javax.swing.JOptionPane.showInputDialog(this,"Informe o c�digo do funcion�rio", "Consulta por C�digo", javax.swing.JOptionPane.PLAIN_MESSAGE));
        }catch (NumberFormatException nfe) {
            return;
        }
        Funcionario f;
        try {
            f = funcionarioDAO.findByPrimaryKey(id,Conexao.getCon());
        }catch (FuncionarioException ex) {
            ex.printStackTrace();
            return;
        }
        if (f != null) {
            try {
                f = funcionarioDAO.carregarSetor(f, Conexao.getCon());
            } catch (FuncionarioException ex) {
                ex.printStackTrace();
            }
            this.setFuncionario(f);
            tratarBotoes();
        }
        
    }//GEN-LAST:event_jbPesquisarActionPerformed
    
    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        
    }//GEN-LAST:event_tfNomeFocusLost
    
    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbFecharActionPerformed
    
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limparCampos();
        tratarBotoes();
    }//GEN-LAST:event_jbCancelarActionPerformed
    
    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        Funcionario funcionario = this.getFuncionario();
        try {
            funcionarioDAO.update(funcionario.getCodigo(),funcionario,Conexao.getCon());
        }catch (FuncionarioException se) {
            JOptionPane.showMessageDialog(this,"Erro ao alterar os dados\n" + se.getMessage(), "Erro na altera��o de dados", JOptionPane.ERROR_MESSAGE);
        }
        
        limparCampos();
        tratarBotoes();
    }//GEN-LAST:event_jbConfirmarActionPerformed
    
    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        int resposta = javax.swing.JOptionPane.showConfirmDialog(this,
                "Tem certeza de que deseja remover" +
                " o funcion�rio\n[" + funcionario.getNome() + "] ?",
                "Remove Funcion�rio",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                funcionarioDAO.delete(funcionario.getCodigo(),Conexao.getCon());
            } catch (FuncionarioException se) {
                JOptionPane.showMessageDialog(this,"Erro ao remover os dados\n" + se.getMessage(), "Erro de exclus�o de dados", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        limparCampos();
        tratarBotoes();
    }//GEN-LAST:event_jbRemoverActionPerformed
    
    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        /*
        this.setSetor(this.getSetorSelecionado());
        tratarBotoes();
         */
    }//GEN-LAST:event_jbConsultarActionPerformed
    
    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        funcionario = this.getFuncionario();

        try {
            funcionarioDAO.insert(funcionario,Conexao.getCon());
            limparCampos();
        } catch (FuncionarioException se) {
            JOptionPane.showMessageDialog(this,"Erro ao inserir os dados\n" + se.getMessage(), "Erro na inser��o dos dados", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastroSetor cs = new CadastroSetor(null, true);
        cs.setVisible(true);
        carregarDadosSetor();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    private List<Setor> carregarDadosSetor() {
        try {
            listaSetores = setorDAO.findAll(Conexao.getCon());
            comboBoxSetores.setModel(new javax.swing.DefaultComboBoxModel(listaSetores.toArray()));
            comboBoxSetores.setSelectedIndex(-1);            
        } catch (SetorException ex) {
            ex.printStackTrace();
        }
        return listaSetores;
    }
    
    private void estabelecerConexaoBD() {
        Conexao.conectar();
        setorDAO = new SetorDAO();
        funcionarioDAO = new FuncionarioDAO();
        dependenteDAO = new DependenteDAO();
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        tfCodigo.setText(Integer.toString(funcionario.getCodigo()));
        tfNome.setText(funcionario.getNome());
        ftfFone.setText(funcionario.getFone());
        ftfCPF.setText(funcionario.getCpf());
        //    this.formatDate(ftfDataNasc);
        SimpleDateFormat formatDateToStr = new SimpleDateFormat("dd/MM/yyyy");
        String novoFormato = formatDateToStr.format(funcionario.getDataNasc());
        ftfDataNasc.setText(novoFormato);
        
        ftfCelular.setText(funcionario.getCelular());
        String strSalario = Double.toString(funcionario.getSalario());
        ftfSalario.setText(strSalario.replace(".",""));
        tfEMail.setText(funcionario.getEmail());
        if (funcionario.getSexo() == 'M')
            rbMasculino.setSelected(true);
        else
            rbFeminino.setSelected(true);
        
        tfObs.setText(funcionario.getObs());
        
        comboBoxSetores.setSelectedItem(funcionario.getSetor());
    }
    
    public Funcionario getFuncionario() {
        if (!jbInserir.isEnabled())
            funcionario.setCodigo(Integer.parseInt(tfCodigo.getText()));
        
        funcionario.setNome(tfNome.getText());
        funcionario.setFone(ftfFone.getText());
        
        funcionario.setCpf(FormatValues.removeMaskCPF(ftfCPF.getText()));
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            funcionario.setDataNasc(sdf.parse(ftfDataNasc.getText()));
        } catch (ParseException pe) {
            javax.swing.JOptionPane.showMessageDialog(null,"Data inv�lida");
        }
        
        funcionario.setCelular(ftfCelular.getText());
        String strSalario = ftfSalario.getText().replaceAll(",",".");
        funcionario.setSalario(Double.parseDouble(strSalario));
        if (rbMasculino.isSelected())
            funcionario.setSexo('M');
        else
            funcionario.setSexo('F');
        
        funcionario.setEmail(tfEMail.getText());
        funcionario.setObs(tfObs.getText());
        funcionario.setSetor((Setor)comboBoxSetores.getSelectedItem());
        return funcionario;
    }
    
    private void limparCampos() {
        funcionario = new Funcionario();
        tfCodigo.setText("");
        tfNome.setText(null);
        ftfFone.setText(null);
        ftfCPF.setText(null);
        tfEMail.setText(null);
        ftfDataNasc.setText(null);
        ftfSalario.setText(null);
        ftfCelular.setText(null);
        tfObs.setText(null);
        rbMasculino.setSelected(true);
        comboBoxSetores.setSelectedIndex(-1);
        FormatValues.formatDate(this.ftfDataNasc);
        FormatValues.formatCPF(this.ftfCPF);
        FormatValues.formatPhoneNumber(this.ftfCelular);
        FormatValues.formatPhoneNumber(this.ftfFone);
    }
    
    private void tratarBotoes() {
        jbInserir.setEnabled(!jbInserir.isEnabled());
        jbPesquisar.setEnabled(!jbPesquisar.isEnabled());
        jbRemover.setEnabled(!jbRemover.isEnabled());
        jbCancelar.setEnabled(!jbCancelar.isEnabled());
        jbConfirmar.setEnabled(!jbConfirmar.isEnabled());
        jbFechar.setEnabled(!jbFechar.isEnabled());
    }
    

    // TODO permitir a inclusao de funcionarios e dependentes desde que haja um funcionario v�lido
    // TODO verificar aonde colocar o BD para distribui��o final
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox comboBoxSetores;
    private javax.swing.JFormattedTextField ftfCPF;
    private javax.swing.JFormattedTextField ftfCelular;
    private javax.swing.JFormattedTextField ftfDataNasc;
    private javax.swing.JFormattedTextField ftfFone;
    private javax.swing.JFormattedTextField ftfSalario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfEMail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextArea tfObs;
    // End of variables declaration//GEN-END:variables
}



