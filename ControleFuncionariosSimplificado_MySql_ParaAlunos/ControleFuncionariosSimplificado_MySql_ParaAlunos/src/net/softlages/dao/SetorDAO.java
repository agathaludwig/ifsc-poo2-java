/*
 * SetorDAO.java
 *
 * Created on 15 de Outubro de 2006, 12:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package net.softlages.dao;

import java.sql.*;
import java.util.*;
import net.softlages.exception.*;
import net.softlages.vo.*;

/**
 *
 * Implementation of SetorDAO interface
 *
 */
public class SetorDAO {

    /**
     * Method deletes a record from table SETOR
     *
     * @param pk the pk is an int value
     * @param con is a Connection value
     * @return int
     * @throws SetorException  
     *
     */
    public int delete(int pk, Connection con) throws SetorException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from  SETOR where CODIGO = ?");
            ps.setInt(1, pk);
            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        }
    }

    /**
     * This method updates a record in table SETOR
     *
     * @param pk an int value
     * @param setor a Setor object
     * @param con a Connection objetc
     * @return int
     * @throws SetorException  
     */
    public int update(int pk, Setor setor, Connection con) throws SetorException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(
                    "update SETOR set NOME = ? , LOCAL = ?  where CODIGO = ?");
            ps.setString(1, setor.getNome());
            ps.setString(2, setor.getLocal());
            ps.setInt(3, pk);

            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        }
    }

    /**
     * This method inserts data in table SETOR
     *
     * @param setor a Setor object
     * @param con a Connection value
     * @return SetorPK
     * @throws SetorException  
     */
    public int insert(Setor setor, Connection con) throws SetorException {
        //se o codigo for autoincremento nao é necessario coloca-lo na instrucao INSERT
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into SETOR(NOME, LOCAL) values (?, ?)");
            //ps.setInt(1,setor.getCodigo());
            ps.setString(1, setor.getNome());
            ps.setString(2, setor.getLocal());

            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        }
    }

    /**
     *
     * Returns a row from the SETOR table for the primary key passed as
     * parameter.
     *
     * @param int codigo
     * @param Connection con
     * @return Setor
     *
     */
    public Setor findByPrimaryKey(int codigo, Connection con) throws SetorException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQLSTATEMENT = "Select CODIGO, NOME, LOCAL from SETOR where CODIGO = ?";
            stmt = con.prepareStatement(SQLSTATEMENT);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            return fetchSingleResult(rs);
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from SETOR table where NOME= nome
     *
     * @param String nome
     * @param Connection con
     * @return List<Setor>
     */
    public List<Setor> findByNome(String nome, Connection con) throws SetorException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, LOCAL from SETOR where NOME like ? order by NOME";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, nome + "%");
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from SETOR table where LOCAL= local
     *
     * @param String local
     * @param Connection con
     * @return List<Setor>
     */
    public List<Setor> findByLocal(String local, Connection con) throws SetorException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, LOCAL from SETOR where LOCAL = ? order by LOCAL";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, local);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        } finally {
        }
    }

    /**
     * Returns all rows from SETOR table
     *
     * @param Connection con
     * @return List<Setor>
     *
     */
    public List<Setor> findAll(Connection con) throws SetorException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, LOCAL from SETOR order by nome";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        } finally {
        }
    }

    /**
     * Returns rows from SETOR table by executing the passed sql statement after
     * setting the passed values in Object[]
     *
     * @param String selectStatement
     * @param Object[] sqlParams
     * @param Connection con
     * @return List<Setor>
     *
     */
    public List<Setor> findExecutingUserSelect(String selectStatement, Object[] sqlParams, Connection con) throws SetorException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_STATEMENT = selectStatement;
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            for (int i = 0; i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        } finally {
        }
    }

    /**
     * Returns rows from SETOR table by executing the select all fields
     * statement after setting the passed where clause and values in Object[]
     *
     * @param String whereClause
     * @param Object[] sqlParams
     * @param Connection con
     * @return List<Setor>
     *
     */
    public List<Setor> findExecutingUserWhere(String whereClause, Object[] sqlParams, Connection con) throws SetorException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_SELECT = "Select CODIGO, NOME, LOCAL from SETOR";
        final String SQL_STATEMENT = SQL_SELECT + " where " + whereClause;
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            for (int i = 0; i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new SetorException(sqle);
        } catch (Exception e) {
            throw new SetorException(e);
        } finally {
        }
    }

    /**
     *
     * Populates a Data Transfer Object by fetching single record from resultSet
     *
     * @param ResultSet rs
     * @return Setor
     *
     */
    protected Setor fetchSingleResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Setor dto = new Setor();
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
     * @param Setor dto
     * @param ResultSet rs
     * @return void
     */
    protected void populateVO(Setor dto, ResultSet rs) throws SQLException {
        dto.setCodigo(rs.getInt("CODIGO"));
        dto.setNome(rs.getString("NOME"));
        dto.setLocal(rs.getString("LOCAL"));
    }

    /**
     *
     * Returns an array of Value Objects by fetching data from resultSet
     *
     * @param ResultSet rs
     * @return List<Setor>
     */
    protected List<Setor> fetchMultiResults(ResultSet rs) throws SQLException {
        List<Setor> resultList = new ArrayList();
        while (rs.next()) {
            Setor dto = new Setor();
            populateVO(dto, rs);
            resultList.add(dto);
        }
        //List<Setor> ret = new ArrayList<Setor>();
        //ret = resultList.toArray();
        return resultList;
    }


}
