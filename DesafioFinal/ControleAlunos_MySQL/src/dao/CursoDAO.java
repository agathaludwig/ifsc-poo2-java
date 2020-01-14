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
import model.Curso;

/**
 *
 * @author Java
 */
public class CursoDAO {


    public void inserir(Curso curso) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_INSERT = 
                "INSERT INTO curso (id, nome, carga_horaria) VALUES (?,?,?)";
            pstm = Conexao.getCon().prepareStatement(SQL_INSERT);
            pstm.setInt(1, curso.getId());
            pstm.setString(2, curso.getNome());
            pstm.setInt(3, curso.getCargaHoraria());
            pstm.executeUpdate();
            System.out.println("Inclusão realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível inserir o curso. \n", sqle);
        } 
    }

    public void atualizar(Curso curso) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_UPDATE =
                "UPDATE curso SET nome = ?, carga_horaria = ? WHERE id = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, curso.getNome());
            pstm.setInt(2, curso.getCargaHoraria());
            pstm.setInt(3, curso.getId());
            pstm.executeUpdate();
            System.out.println("Atualização realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível atualizar o curso. \n", sqle);
        } 
    }
    
    public void remover(Curso curso) throws ExceptionBD {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "DELETE FROM curso WHERE id = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, curso.getId());
            if (pstm.executeUpdate() == 0) 
                throw new ExceptionBD("Curso não identificado pelo seu id.\n");
            System.out.println("Exclusão realizada com sucesso!");
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível remover o curso. \n", sqle);
        } 
    }

    public Curso getCursoPorId(int id) throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_ID = 
                    "SELECT * FROM curso WHERE id = ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return carregarResultadoSimples(rs);
        }catch(SQLException sqle){
            throw new ExceptionBD ("Não foi possível localizar o curso. \n", sqle);
        }   finally {
        }
    }

/*    public List<Curso> getCursoPorNome(String nome) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_NOME =
                    "SELECT * FROM curso WHERE nome LIKE ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_NOME);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
        }
    }
*/       
    public ArrayList<Curso> findAll() throws ExceptionBD {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="SELECT * FROM curso ORDER BY nome";
        try {
            stmt = Conexao.getCon().prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            throw new ExceptionBD("Não foi possível localizar os cursos", sqle);
        } finally{}
    }

    private ArrayList<Curso> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        ArrayList<Curso> resultList = new ArrayList<>();
        while (rs.next()) {
            Curso dto = new Curso();
            carregarVO( dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }

    private Curso carregarResultadoSimples(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Curso dto = new Curso();
            carregarVO(dto, rs);
            return dto;
        } else {
            return null;
        }
    }
    
    private void carregarVO(Curso dto, ResultSet rs)throws SQLException{
        dto.setId(rs.getInt("ID"));
        dto.setNome(rs.getString("NOME"));
        dto.setCargaHoraria(rs.getInt("CARGA_HORARIA"));
    }
}
