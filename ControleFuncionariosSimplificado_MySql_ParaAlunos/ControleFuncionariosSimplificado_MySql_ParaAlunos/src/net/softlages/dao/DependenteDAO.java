/*
 * DependenteDAO.java
 *
 * Created on 21 de Outubro de 2006, 12:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package net.softlages.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.softlages.exception.DependenteException;
import net.softlages.vo.Dependente;

/**
 *
 * @author java
 */
public class DependenteDAO {

    private FuncionarioDAO funcionarioDAO;

    /**
     * Method deletes a record from table DEPENDENTE
     *
     * @param pk an int value
     * @param con a Connection object
     * @return int
     * @throws DependenteException  
     *
     */
    public int delete(int pk, Connection con) throws DependenteException {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("delete from  DEPENDENTE where CODIGO = ?");
            ps.setInt(1, pk);
            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        }
    }

    /**
     * This method updates a record in table DEPENDENTE
     *
     * @param pk an int value
     * @param dependente a Dependente object
     * @param con a Connection object
     * @return int
     * @throws DependenteException  
     */
    public int update(int pk, Dependente dependente, Connection con) throws DependenteException {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update DEPENDENTE set NOME = ? , SEXO = ? , DATANASC = ? , PARENTESCO = ? , FUNCIONARIO_CODIGO = ?  where CODIGO = ?");
            ps.setString(1, dependente.getNome());
            ps.setString(2, dependente.getSexo());
            ps.setDate(3, new java.sql.Date(dependente.getDataNasc().getTime()));
            ps.setInt(4, dependente.getParentesco());
            ps.setInt(5, dependente.getFuncionario().getCodigo());
            ps.setInt(6, pk);

            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        }
    }

    /**
     * This method inserts data in table DEPENDENTE
     *
     * @param dependente a Dependente object
     * @param con a Connection object
     * @return DependentePK
     * @throws DependenteException  
     */
    public int insert(Dependente dependente, Connection con) throws DependenteException {

        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into DEPENDENTE( NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO) values (?, ?, ?, ?, ?)");
            ps.setString(1, dependente.getNome());
            ps.setString(2, dependente.getSexo());
            ps.setDate(3, new java.sql.Date(dependente.getDataNasc().getTime()));
            ps.setInt(4, dependente.getParentesco());
            ps.setInt(5, dependente.getFuncionario().getCodigo());

            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        }
    }

    /**
     *
     * Returns a row from the DEPENDENTE table for the primary key passed as
     * parameter.
     *
     * @param codigo an int value
     * @param con a Connection object
     * @return
     * @throws DependenteException  
     */
    public Dependente findByPrimaryKey(int codigo, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        try {
            final String SQLSTATEMENT = "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO from DEPENDENTE where CODIGO = ?";
            stmt = con.prepareStatement(SQLSTATEMENT);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            return fetchSingleResult(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from DEPENDENTE table where NOME= nome
     *
     * @param nome a String value
     * @param con a Connection object
     * @return List<Dependente>
     * @throws DependenteException  
     */
    public List<Dependente> findByNome(String nome, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        String SQL_STATEMENT = "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO from DEPENDENTE where NOME = ? order by NOME";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from DEPENDENTE table where SEXO= sexo
     *
     * @param sexo a String value
     * @param con a Connection object
     * @return List<Dependente>
     * @throws DependenteException  
     */
    public List<Dependente> findBySexo(String sexo, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        String SQL_STATEMENT = "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO from DEPENDENTE where SEXO = ? order by SEXO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, sexo);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from DEPENDENTE table where PARENTESCO= parentesco
     *
     * @param parentesco an int value
     * @param con a Connection object
     * @return List<Dependente>
     * @throws DependenteException  
     */
    public List<Dependente> findByParentesco(int parentesco, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        String SQL_STATEMENT = "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO from DEPENDENTE where PARENTESCO = ? order by PARENTESCO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setInt(1, parentesco);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from DEPENDENTE table where FUNCIONARIO_CODIGO=
     * funcionario_codigo
     *
     * @param funcionario_codigo an int value 
     * @param con a Connection Object
     * @return List<Dependente>
     * @throws DependenteException  
     */
    public List<Dependente> findByFuncionario_codigo(int funcionario_codigo, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        String SQL_STATEMENT = "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO from DEPENDENTE where FUNCIONARIO_CODIGO = ? order by FUNCIONARIO_CODIGO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setInt(1, funcionario_codigo);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     * Returns all rows from DEPENDENTE table
     *
     * @param con a Connection object
     * @return List<Dependente>
     * @throws DependenteException  
     *
     */
    public List<Dependente> findAll(Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        String SQL_STATEMENT = "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO from DEPENDENTE";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     * Returns rows from DEPENDENTE table by executing the passed sql statement
     * after setting the passed values in Object[]
     *
     * @param selectStatement a String value
     * @param sqlParams an Object[] array
     * @param con a Connection 
     * @return List<Dependente>
     * @throws DependenteException  
     *
     */
    public List<Dependente> findExecutingUserSelect(String selectStatement, Object[] sqlParams, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        final String SQL_STATEMENT = selectStatement;
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            for (int i = 0; i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     * Returns rows from DEPENDENTE table by executing the select all fields
     * statement after setting the passed where clause and values in Object[]
     *
     * @param whereClause a String value
     * @param sqlParams an Object[] array 
     * @param con a Connection object
     * @return List<Dependente>
     * @throws DependenteException  
     *
     */
    public List<Dependente> findExecutingUserWhere(String whereClause, Object[] sqlParams, Connection con) throws DependenteException {
        PreparedStatement stmt;
        ResultSet rs;
        String SQL_SELECT = 
                "Select CODIGO, NOME, SEXO, DATANASC, PARENTESCO, FUNCIONARIO_CODIGO "
                + "from DEPENDENTE";
        final String SQL_STATEMENT = SQL_SELECT + " where " + whereClause;
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            for (int i = 0; i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new DependenteException(sqle);
        } catch (Exception e) {
            throw new DependenteException(e);
        } finally {
        }
    }

    /**
     *
     * Populates a Data Transfer Object by fetching single record from resultSet
     *
     * @param rs a ResultSet object
     * @return Dependente
     * @throws SQLException  
     *
     */
    protected Dependente fetchSingleResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Dependente dto = new Dependente();
            populateVO(dto, rs);
            return dto;
        } else {
            return null;
        }
    }

    /**
     *
     * Populates a Data Transfer Object by fetching data from ResultSet
     *
     * @param dto a Dependente dto (data transfer object)
     * @param rs a ResultSet object
     * @throws SQLException  
     * 
     */
    protected void populateVO(Dependente dto, ResultSet rs) throws SQLException {
        dto.setCodigo(rs.getInt("CODIGO"));
        dto.setNome(rs.getString("NOME"));
        dto.setSexo(rs.getString("SEXO"));
        dto.setDataNasc(rs.getDate("DATANASC"));
        dto.setParentesco(rs.getInt("PARENTESCO"));
    }

    /**
     *
     * Returns an array of Value Objects by fetching data from resultSet
     *
     * @param rs a ResultSet object
     * @return List<Dependente>
     * @throws SQLException  
     */
    protected List<Dependente> fetchMultiResults(ResultSet rs) throws SQLException {
        List<Dependente> resultList = new ArrayList();
        while (rs.next()) {
            Dependente dto = new Dependente();
            populateVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
}
