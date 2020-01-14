/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import exceptions.ExceptionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.Curso;
import model.Professor;
import model.Turma;

/**
 *
 * @author Java
 */
public class TurmaDAO {

    private Curso c = new Curso();
    private CursoDAO cDAO = new CursoDAO();
    private ArrayList<Curso> cursos = new ArrayList<>();

    private Professor p = new Professor();
    private ProfessorDAO pDAO = new ProfessorDAO();
    private ArrayList<Professor> professores = new ArrayList<>();

    public void inserir(Turma turma) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_INSERT
                    = "INSERT INTO turma (idturma, ano, semestre, idCurso, matProfessor) "
                    + "values (?,?,?,?,?)";
            pstm = Conexao.getCon().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, turma.getIdTurma());
            pstm.setString(2, turma.getAno());
            pstm.setString(3, turma.getSemestre());
            pstm.setInt(4, turma.getCurso().getId());
            pstm.setInt(5, turma.getProfessor().getMatricula());
            pstm.executeUpdate();
            System.out.println("Inclusão realizada com sucesso!");

            ResultSet rs = pstm.getGeneratedKeys();
            while (rs.next()) {
                int idObjeto = rs.getInt(1);
                turma.setIdTurma(idObjeto);
                System.out.println("Turma setada: " + turma.getIdTurma());
            }
       }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível inserir turma. \n", sqle);
        } 
        this.inserirAlunos(turma); 
    }

    public void atualizar(Turma turma) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_UPDATE
                    = "UPDATE turma SET ano = ?, semestre = ?, "
                    + "idCurso = ?, matProfessor = ? WHERE idturma = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, turma.getAno());
            pstm.setString(2, turma.getSemestre());
            pstm.setInt(3, turma.getCurso().getId());
            pstm.setInt(4, turma.getProfessor().getMatricula());
            pstm.setInt(5, turma.getIdTurma());
            pstm.executeUpdate();
            System.out.println("Atualização realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível atualizar a turma. \n", sqle);
        } 
        this.removerAlunos(turma);
        this.inserirAlunos(turma);

    }

    public void remover(Turma turma) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "DELETE FROM turma WHERE idturma = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, turma.getIdTurma());
            pstm.executeUpdate();
            System.out.println("Exclusão de turma realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível remover a turma. \n", sqle);
        } 
    }

    public Turma getTurmaPorId(int idTurma) throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_ID
                    = "SELECT * FROM turma JOIN alunoTurma ON turma.idTurma = alunoTurma.idTurma "
                    + "JOIN aluno ON alunoTurma.matAluno = aluno.matricula "
                    + "WHERE turma.idTurma = ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_ID);
            stmt.setInt(1, idTurma);
            rs = stmt.executeQuery();
            return carregarDados(rs);
        } catch (SQLException sqle) {
            throw new ExceptionBD("Erro ao buscar turma!!!\n", sqle);
        } finally {
        }
    }

    private Turma carregarDados(ResultSet rs){
        Turma turma = null;
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
        int cont = 0;
        try {
            while (rs.next()) {
                cont++;
                if (cont == 1) {
                    turma = new Turma();
                    turma.setIdTurma(rs.getInt("idTurma"));
                    turma.setAno(rs.getString("ano"));
                    turma.setSemestre(rs.getString("semestre"));
                    ProfessorDAO pDAO = new ProfessorDAO();
                    try {
                        turma.setProfessor(pDAO.getProfessorPorId(rs.getInt("matProfessor")));
                    } catch (ExceptionBD ex) {
                        System.out.println("Erro ao buscar professor.\n" + ex.getMessage());
                    }
                    
                    CursoDAO cDAO = new CursoDAO();
                    try {
                        turma.setCurso(cDAO.getCursoPorId(rs.getInt("idCurso")));
                    } catch (ExceptionBD ex) {
                        System.out.println("Erro ao buscar curso.\n" + ex.getMessage());
                    }
                }
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRenda(rs.getDouble("renda"));
                turma.getAlunos().add(aluno);
            }
        } catch (SQLException sqle) {
            System.out.println("Erro ao carregar turmaadastro.\n" + sqle.getMessage());
        }
        return turma;
    }

    private Turma carregarResultadoSimples(ResultSet rs) throws SQLException, ExceptionBD, Exception {
        if (rs.next()) {
            Turma dto = new Turma();
            carregarVO(dto, rs);
            return dto;
        } else {
            return null;
        }
    }

    private void carregarVO(Turma dto, ResultSet rs) throws SQLException, ExceptionBD, Exception {
        dto.setAno(rs.getString("ano"));
        dto.setSemestre(rs.getString("semestre"));

        dto.setCurso(cDAO.getCursoPorId(rs.getInt("idCurso")));
        dto.setProfessor(pDAO.getProfessorPorId(rs.getInt("matProfessor")));
    }

    public void inserirAlunos(Turma turma) throws ExceptionBD {
        PreparedStatement pstm = null;
        int n = 0;
        for (Aluno aluno : turma.getAlunos()) {
            try {
                final String SQL_INSERT = "INSERT INTO alunoTurma (idTurma, matAluno) "
                        + "values (?,?)";
                pstm = Conexao.getCon().prepareStatement(SQL_INSERT);
                pstm.setInt(1, turma.getIdTurma());
                pstm.setInt(2, aluno.getMatricula());
                pstm.executeUpdate();
                n++;
                System.out.println("Inclusão realizada com sucesso!");

            } catch (SQLException sqle) {
               throw new ExceptionBD("Erro ao inserir aluno na turma!!!\n", sqle);
            }
        }
        System.out.println(n + " alunos incluidos com sucesso!");
    }

    public void removerAlunos(Turma turma) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "DELETE FROM alunoTurma WHERE idTurma = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, turma.getIdTurma());
            pstm.executeUpdate();
            System.out.println("Todos alunos foram removidos da turma!");

        } catch (SQLException sqle) {
            throw new ExceptionBD("Erro ao remover alunos da turma!!!\n", sqle);
        }
    }
}
