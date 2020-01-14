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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.EnumTitulacao;
import model.Professor;

/**
 *
 * @author Java
 */
public class ProfessorDAO {


    public void inserir(Professor professor) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_INSERT = 
                "INSERT INTO professor (matricula, nome, titulacao, salario) " +
                "values (?,?,?,?)";
            pstm = Conexao.getCon().prepareStatement(SQL_INSERT);
            pstm.setInt(1, professor.getMatricula());
            pstm.setString(2, professor.getNome());
            pstm.setString(3, professor.getTitulacao().toString());
            pstm.setDouble(4, professor.getSalario());
            pstm.executeUpdate();
            System.out.println("Inclusão realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível inserir o professor. \n", sqle);
        } 
    }

    public void atualizar(Professor professor) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_UPDATE =
                "UPDATE professor SET nome = ?, titulacao = ?, " +
                "salario = ? WHERE matricula = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, professor.getNome());
            pstm.setString(2, professor.getTitulacao().toString());
            pstm.setDouble(3, professor.getSalario());
            pstm.setInt(4, professor.getMatricula());
            pstm.executeUpdate();
            System.out.println("Atualização realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível atualizar o professor. \n", sqle);
        } 
    }
    
    public void remover(Professor professor) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "DELETE FROM professor WHERE matricula = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, professor.getMatricula());
            pstm.executeUpdate();
            System.out.println("Exclusão realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível remover o professor. \n", sqle);
        } 
        
    }

    public Professor getProfessorPorId(int matricula) throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_MATRICULA = 
                    "SELECT * FROM professor WHERE matricula = ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_MATRICULA);
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();
            return carregarResultadoSimples(rs);
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível localizar o professor. \n", sqle);
        }  finally {
        }
    }

    private Professor carregarResultadoSimples(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Professor dto = new Professor();
            carregarVO(dto, rs);
            return dto;
        } else {
            return null;
        }
    }
    
     public ArrayList<Professor> findAll() throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="SELECT * FROM professor ORDER BY nome";
        try {
            stmt = Conexao.getCon().prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível localizar os professores", sqle);
        } finally{}
    }

    private ArrayList<Professor> carregarMultiplosResultados(ResultSet rs) throws ExceptionBD {
        try {
            ArrayList<Professor> resultList = new ArrayList<>();
            while (rs.next()) {
                Professor dto = new Professor();
                carregarVO(dto, rs);
                resultList.add(dto);
            }
            return resultList;
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível localizar os professores. \n", sqle);
        } 
    }

    private void carregarVO(Professor dto, ResultSet rs)throws SQLException{
        dto.setMatricula(rs.getInt("matricula"));
        dto.setNome(rs.getString("nome"));
        dto.setTitulacao(rs.getString("titulacao"));
        dto.setSalario(rs.getDouble("salario"));
    }
}
