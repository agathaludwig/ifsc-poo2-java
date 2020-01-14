/*
 * Se eu descomento o ColumnModel não carrega os checkbox (?)
 *
 * ALUNOS : adicionar turma na classe aluno
 */
package gui;

import conexao.Conexao;
import dao.AlunoDAO;
import dao.CursoDAO;
import dao.ProfessorDAO;
import dao.TurmaDAO;
import exceptions.ExceptionBD;
import gui.table.AlunoTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Curso;
import model.Professor;
import model.Turma;

/**
 *
 * @author Java
 */
public class CadTurma extends javax.swing.JFrame {

    private Curso c = new Curso();
    private CursoDAO cDAO = new CursoDAO();
    private ArrayList<Curso> todosCursos = new ArrayList<>();

    private Professor p = new Professor();
    private ProfessorDAO pDAO = new ProfessorDAO();
    private ArrayList<Professor> todosProfs = new ArrayList<>();

    private Aluno a = new Aluno();
    private AlunoDAO aDAO = new AlunoDAO();
    private ArrayList<Aluno> todosAlunos = new ArrayList<>();

    Turma t = new Turma();
    TurmaDAO dao = new TurmaDAO();

    /**
     * Creates new form CadAlunos
     */
    public CadTurma() throws ExceptionBD {
        initComponents();
        todosCursos = carregarCursos();
        todosProfs = carregarProfessores();
        todosAlunos = carregarAlunos();
        jTableAlunos.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = jTableAlunos.getFontMetrics(jTableAlunos.getFont());
        //jTableAlunos.setColumnModel(new AlunoColumnModel(fm)); //erro
        //this.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfAno = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        tfSemestre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox<>();
        cbProfessor = new javax.swing.JComboBox<>();
        cbAlunos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btInsereAluno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlunos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        btRemoverAluno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ano:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Curso:");

        tfAno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
        jLabel3.setText("Professor:");

        btAtualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAtualizar.setText("Alterar");
        btAtualizar.setEnabled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

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

        tfSemestre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Semestre:");

        cbProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Alunos:");

        btInsereAluno.setText("Inserir Aluno");
        btInsereAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsereAlunoActionPerformed(evt);
            }
        });

        jTableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matrícula", "Nome", "CPF", "Renda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAlunos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ID:");

        tfId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btRemoverAluno.setText("Remover Aluno");
        btRemoverAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(213, 213, 213)
                                    .addComponent(btLimpar))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btPesquisar)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(3, 3, 3)
                                        .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(4, 4, 4)
                                        .addComponent(tfSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btSalvar)
                                        .addGap(30, 30, 30)
                                        .addComponent(btAtualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btExcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btFechar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btRemoverAluno)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btInsereAluno))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tfSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInsereAluno)
                    .addComponent(btRemoverAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btAtualizar)
                    .addComponent(btExcluir)
                    .addComponent(btFechar)
                    .addComponent(btLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(jLabel4)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        t.setAno(tfAno.getText());
        t.setSemestre(tfSemestre.getText());
        t.setCurso((Curso) cbCurso.getSelectedItem());
        t.setProfessor((Professor) cbProfessor.getSelectedItem());

        try {
            dao.inserir(t);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir turma no cadastro.\n" + ex.getMessage());
        }
        limparCampos();

}//GEN-LAST:event_btSalvarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        int id = Integer.parseInt(tfId.getText());
        try {
            t = dao.getTurmaPorId(id);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar turma no cadastro.\n" + ex.getMessage());
        }
        if (t == null) {
            JOptionPane.showMessageDialog(this, "Turma não localizada");
        } else {
            tfAno.setText(t.getAno());
            tfSemestre.setText(t.getSemestre());
            cbCurso.setSelectedItem(t.getCurso());
            cbProfessor.setSelectedItem(t.getProfessor());
            this.setListaAlunos(t.getAlunos());
            btAtualizar.setEnabled(true);
        }

}//GEN-LAST:event_btPesquisarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Conexao.encerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        t.setAno(tfAno.getText());
        t.setSemestre(tfSemestre.getText());
        t.setCurso((Curso) cbCurso.getSelectedItem());
        t.setProfessor((Professor) cbProfessor.getSelectedItem());

        try {
            dao.atualizar(t);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar turma no cadastro.\n" + ex.getMessage());
        }
        limparCampos();
}//GEN-LAST:event_btAtualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int id = Integer.parseInt(tfId.getText());
        t.setIdTurma(id);

        try {
            dao.remover(t);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir turma no cadastro.\n" + ex.getMessage());
        }
        limparCampos();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCampos();
        btAtualizar.setEnabled(false);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btInsereAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsereAlunoActionPerformed
        Aluno alunoSelecionado;
        alunoSelecionado = (Aluno) cbAlunos.getSelectedItem();
        if (!t.getAlunos().contains(alunoSelecionado)) {
            t.getAlunos().add(alunoSelecionado);
            this.setListaAlunos(t.getAlunos());
        } else {
            JOptionPane.showMessageDialog(this, "Este aluno já foi inserido");
        }

    }//GEN-LAST:event_btInsereAlunoActionPerformed

    private void btRemoverAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverAlunoActionPerformed
        Aluno alunoSelecionado = new Aluno();
        try {
            //alunoSelecionado = (Aluno) cbAlunos.getSelectedItem();
            //System.out.println();
            alunoSelecionado = aDAO.getAlunoPorId((int) jTableAlunos.getValueAt(jTableAlunos.getSelectedRow(),0));
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar aluno.\n " + ex.getMessage());
        }
        
        if (t.getAlunos().contains(alunoSelecionado)) {
            t.getAlunos().remove(alunoSelecionado);
            this.setListaAlunos(t.getAlunos());
        } else {
            JOptionPane.showMessageDialog(this, "Este aluno não pertence a turma");
        }

    }//GEN-LAST:event_btRemoverAlunoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btInsereAluno;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemoverAluno;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbAlunos;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlunos;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfSemestre;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        this.t = new Turma();
        tfAno.setText(null);
        tfSemestre.setText(null);
        cbCurso.setSelectedItem(null);
        cbProfessor.setSelectedItem(null);
        cbAlunos.setSelectedItem(null);
        this.setListaAlunos(t.getAlunos());
        btAtualizar.setEnabled(false);
        tfAno.requestFocus();
    }

    private ArrayList<Curso> carregarCursos() throws ExceptionBD {
        try {
            todosCursos = cDAO.findAll();
            cbCurso.setModel(new javax.swing.DefaultComboBoxModel(todosCursos.toArray()));
            cbCurso.setSelectedIndex(-1);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar cursos.\n " + ex.getMessage());
            
        }
        return todosCursos;
    }

    private ArrayList<Professor> carregarProfessores() {
        try {
            todosProfs = pDAO.findAll();
            cbProfessor.setModel(new javax.swing.DefaultComboBoxModel(todosProfs.toArray()));
            cbProfessor.setSelectedIndex(-1);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar professores.\n " + ex.getMessage());
        }
        return todosProfs;
    }

    private ArrayList<Aluno> carregarAlunos() {
        try {
            todosAlunos = aDAO.findAll();
            cbAlunos.setModel(new javax.swing.DefaultComboBoxModel(todosAlunos.toArray()));
            cbAlunos.setSelectedIndex(-1);
        } catch (ExceptionBD ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar alunos.\n " + ex.getMessage());
        }
        return todosAlunos;
    }

    private void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.jTableAlunos.setModel(new AlunoTableModel(listaAlunos));
    }

}
