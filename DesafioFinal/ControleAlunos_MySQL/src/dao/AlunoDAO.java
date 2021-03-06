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
import model.Aluno;

/**
 *
 * @author Java
 */
public class AlunoDAO {


    public void inserir(Aluno aluno) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_INSERT = 
                "insert into aluno (MATRICULA,NOME, ENDERECO, CPF, RENDA) " +
                "values (?,?,?,?,?)";
            pstm = Conexao.getCon().prepareStatement(SQL_INSERT);
            pstm.setInt(1, aluno.getMatricula());
            pstm.setString(2, aluno.getNome());
            pstm.setString(3, aluno.getEndereco());
            pstm.setString(4, aluno.getCpf());
            pstm.setDouble(5, aluno.getRenda());
            pstm.executeUpdate();
            System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException sqle) {
            throw new ExceptionBD("Erro ao inserir aluno.\n", sqle);
        }
    }

    public void atualizar(Aluno aluno) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_UPDATE =
                "UPDATE aluno SET nome = ?, endereco = ?, " +
                "cpf = ?, renda = ? WHERE matricula = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getEndereco());
            pstm.setString(3, aluno.getCpf());
            pstm.setDouble(4, aluno.getRenda());
            pstm.setInt(5, aluno.getMatricula());
            pstm.executeUpdate();
            System.out.println("atualização realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível atualizar o aluno. \n", sqle);
        }
    }
    
    public void remover(Aluno aluno) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "delete from aluno where matricula = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, aluno.getMatricula());
            pstm.executeUpdate();
            System.out.println("Exclusão realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível remover o aluno. \n", sqle);
        }
    }

    public Aluno getAlunoPorId(int matricula) throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_MATRICULA = 
                    "select * from aluno where matricula = ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_MATRICULA);
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();
            return carregarResultadoSimples(rs);
        } catch (SQLException sqle) {
            throw new ExceptionBD("Aluno não encontrado com a matricula " + matricula, sqle);
        } finally {
        }
    }
    

    /*public List<Aluno> getAlunoPorNome(String nome) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_MATRICULA =
                    "select * from aluno where nome like ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_MATRICULA);
            stmt.setString(1, nome + "%");
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
        }
    }*/
       
    public ArrayList<Aluno> findAll() throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select MATRICULA, NOME, ENDERECO, CPF, RENDA" +
                " from aluno order by NOME";
        try {
            stmt = Conexao.getCon().prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível localizar os alunos. \n", sqle);
        } finally{}
    }

    private ArrayList<Aluno> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        ArrayList<Aluno> resultList = new ArrayList<>();
        while (rs.next()) {
            Aluno dto = new Aluno();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }

    private Aluno carregarResultadoSimples(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Aluno dto = new Aluno();
            carregarVO(dto, rs);
            return dto;
        } else {
            return null;
        }
    }

    private void carregarVO(Aluno dto, ResultSet rs)throws SQLException{
        dto.setMatricula(rs.getInt("MATRICULA"));
        dto.setNome(rs.getString("NOME"));
        dto.setEndereco(rs.getString("ENDERECO"));
        dto.setRenda(rs.getDouble("RENDA"));
        dto.setCpf(rs.getString("CPF"));
    }
    
}
