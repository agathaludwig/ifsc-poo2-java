/*
 * FuncionarioDAO.java
 *
 * Created on 18 de Outubro de 2006, 14:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package net.softlages.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;
import net.softlages.exception.*;
import net.softlages.vo.*;

/**
 *
 * Implementation of FuncionarioDAO interface
 *
 * @author Marcos André Pisching
 */
public class FuncionarioDAO {

    /**
     * Method deletes a record from table FUNCIONARIO
     *
     * @param int pk
     * @param Connection con
     * @return int
     *
     */
    public int delete(int pk, Connection con) throws FuncionarioException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from  FUNCIONARIO where CODIGO = ?");
            ps.setInt(1, pk);
            return (ps.executeUpdate());
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        }
    }

    /**
     * This method updates a record in table FUNCIONARIO
     *
     * @param int pk
     * @param Funcionario
     * @param Connection con
     * @return int
     */
    public int update(int pk, Funcionario funcionario, Connection con) throws FuncionarioException {
        int id = -1;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(
                    "update FUNCIONARIO "
                    + "set NOME = ? , FONE = ? ,"
                    + " CPF = ? , DATANASC = ? , "
                    + "SEXO = ? , CELULAR = ? , "
                    + "EMAIL = ? , SALARIO = ? , "
                    + "OBS = ? , SETOR_CODIGO = ?  "
                    + "where CODIGO = ?");
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getFone());
            ps.setString(3, funcionario.getCpf());
            ps.setDate(4, 
                    new java.sql.Date(
                    funcionario.getDataNasc().getTime()));
            ps.setString(5, Character.toString(funcionario.getSexo()));
            ps.setString(6, funcionario.getCelular());
            ps.setString(7, funcionario.getEmail());
            ps.setDouble(8, funcionario.getSalario());
            ps.setString(9, funcionario.getObs());
            ps.setInt(10, funcionario.getSetor().getCodigo());
            ps.setInt(11, pk);
            id = ps.executeUpdate();
//            Iterator it = funcionario.getDependentes().listIterator(0);
//            while (it.hasNext()) {
//                Dependente dep = (Dependente)it.next();
//                if (dep.getCodigo() > 0)
//                    dependenteDAO.update(dep.getCodigo(),dep,Conexao.getCon());
//                else
//                    dependenteDAO.insert(dep,Conexao.getCon());
//            }
            return id;
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        }
    }

    /**
     * This method inserts data in table FUNCIONARIO
     *
     * @param Funcionario funcionario
     * @param Connection con
     * @return pk
     */
    public int insert(Funcionario funcionario, Connection con) throws FuncionarioException {
        int id = -1;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into FUNCIONARIO( NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getFone());
            ps.setString(3, funcionario.getCpf());
            ps.setDate(4, new java.sql.Date(funcionario.getDataNasc().getTime()));
            //ps.setString(5,new String(""+funcionario.getSexo()));
            ps.setString(5, Character.toString(funcionario.getSexo()));
            ps.setString(6, funcionario.getCelular());
            ps.setString(7, funcionario.getEmail());
            ps.setDouble(8, funcionario.getSalario());
            ps.setString(9, funcionario.getObs());
            ps.setInt(10, funcionario.getSetor().getCodigo());
            id = ps.executeUpdate();
            return id;
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        }
    }

    /**
     *
     * Returns a row from the FUNCIONARIO table for the primary key passed as
     * parameter.
     *
     */
    public Funcionario findByPrimaryKey(int codigo, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //select f.codigo, f.nome, f.cpf, f.datanasc, f.sexo, f.celular, f.email, f.salario, f.obs, s.codigo, s.nome, s.local from funcionario f, setor s where f.setor_codigo = s.codigo;
        try {
            final String SQLSTATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where CODIGO = ?";
            stmt = con.prepareStatement(SQLSTATEMENT);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            return fetchSingleResult(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where NOME= nome
     *
     * @param String nome
     * @param Connection con
     * @return List<Funcionario>
     */
    public List<Funcionario> findByNome(String nome, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where NOME = ? order by NOME";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where CPF= cpf
     *
     * @param String cpf
     * @param Connection con
     * @return Funcionario
     */
    public Funcionario findByCpf(String cpf, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where CPF = ? order by CPF";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            return fetchSingleResult(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns an id from FUNCIONARIO table where CPF= cpf
     *
     * @param String cpf
     * @param Connection con
     * @return int
     */
    public int findIdByCpf(String cpf, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO from FUNCIONARIO where CPF = ?";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("CODIGO");
            } else {
                return 0;
            }
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where DATANASC= datanasc
     *
     * @param Date datanasc
     * @param Connection con
     * @return List<Funcionario>
     */
    public List<Funcionario> findByDatanasc(Date datanasc, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where DATANASC = ? order by DATANASC";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setDate(1, (java.sql.Date) datanasc);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where SEXO= sexo
     *
     * @param String sexo
     * @param Connection con
     * @return List<Funcionario>
     */
    public List<Funcionario> findBySexo(String sexo, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where SEXO = ? order by SEXO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, sexo);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where SALARIO= salario
     *
     * @param double salario
     * @param Connection con
     * @return List<Funcionario>
     */
    public List<Funcionario> findBySalario(double salario, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where SALARIO = ? order by SALARIO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setDouble(1, salario);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where SALARIO >= salario
     *
     * @param double salario
     * @param Connection con
     * @return List<Funcionario>
     */
    public List<Funcionario> findBySalarioGreaterThan(double salario, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where SALARIO >= ? order by SALARIO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setDouble(1, salario);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Returns all rows from FUNCIONARIO table where SETOR_CODIGO= setor_codigo
     *
     * @param int setor_codigo
     * @param Connection con
     * @return List<Funcionario>
     */
    public List<Funcionario> findBySetor(int setor_codigo, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO where SETOR_CODIGO = ? order by SETOR_CODIGO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setInt(1, setor_codigo);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     * Returns all rows from FUNCIONARIO table
     *
     * @param Connection con
     * @return List<Funcionario>
     *
     */
    public List<Funcionario> findAll(Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    public Funcionario carregarSetor(Funcionario funcionario, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select S.CODIGO, S.NOME, S.LOCAL from SETOR S, FUNCIONARIO F WHERE F.CODIGO = ? AND F.SETOR_CODIGO = S.CODIGO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setInt(1, funcionario.getCodigo());
            rs = stmt.executeQuery();
            if (rs.next()) {
                Setor setor = new Setor();
                setor.setCodigo(rs.getInt(1));
                setor.setLocal(rs.getString(2));
                setor.setNome(rs.getString(3));
                funcionario.setSetor(setor);
            } else {
                funcionario.setSetor(null);
            }
            return funcionario;
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    public Funcionario carregarDependentes(Funcionario funcionario, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select D.CODIGO, D.NOME, D.SEXO, D.DATANASC, D.PARENTESCO, D.FUNCIONARIO_CODIGO from FUNCIONARIO F, DEPENDENTE D WHERE F.CODIGO = ? AND D.FUNCIONARIO_CODIGO = F.CODIGO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            stmt.setInt(1, funcionario.getCodigo());
            rs = stmt.executeQuery();
            funcionario.getDependentes().clear();
            while (rs.next()) {
                Dependente dependente = new Dependente();
                dependente.setCodigo(rs.getInt(1));
                dependente.setNome(rs.getString(2));
                dependente.setSexo(rs.getString(3));
                dependente.setDataNasc(rs.getDate(4));
                dependente.setParentesco(rs.getInt(5));
                funcionario.addDependente(dependente);
                dependente.setFuncionario(funcionario);
            }
            return funcionario;
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     * Returns rows from FUNCIONARIO table by executing the passed sql statement
     * after setting the passed values in Object[]
     *
     * @param String selectStatement
     * @param Object[] sqlParams
     * @param Connection con
     * @return List<Funcionario>
     *
     */
    public List<Funcionario> findExecutingUserSelect(String selectStatement, Object[] sqlParams, Connection con) throws FuncionarioException {
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
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     * Returns rows from FUNCIONARIO table by executing the select all fields
     * statement after setting the passed where clause and values in Object[]
     *
     * @param String whereClause
     * @param Object[] sqlParams
     * @param Connection con
     * @return List<Funcionario>
     *
     */
    public List<Funcionario> findExecutingUserWhere(String whereClause, Object[] sqlParams, Connection con) throws FuncionarioException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_SELECT = "Select CODIGO, NOME, FONE, CPF, DATANASC, SEXO, CELULAR, EMAIL, SALARIO, OBS, SETOR_CODIGO from FUNCIONARIO";
        final String SQL_STATEMENT = SQL_SELECT + " where " + whereClause;
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            for (int i = 0; i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }
            rs = stmt.executeQuery();
            return fetchMultiResults(rs);
        } catch (SQLException sqle) {
            throw new FuncionarioException(sqle);
        } catch (Exception e) {
            throw new FuncionarioException(e);
        } finally {
        }
    }

    /**
     *
     * Populates a Data Transfer Object by fetching single record from resultSet
     *
     * @param ResultSet rs
     * @return Funcionario
     *
     */
    protected Funcionario fetchSingleResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Funcionario dto = new Funcionario();
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
     * @param Funcionario dto
     * @param ResultSet rs
     * @return void
     */
    protected void populateVO(Funcionario dto, ResultSet rs) throws SQLException {
        dto.setCodigo(rs.getInt("CODIGO"));
        dto.setNome(rs.getString("NOME"));
        dto.setFone(rs.getString("FONE"));
        dto.setCpf(rs.getString("CPF"));
        dto.setDataNasc(rs.getDate("DATANASC"));
        dto.setSexo(rs.getString("SEXO").charAt(0));
        dto.setCelular(rs.getString("CELULAR"));
        dto.setEmail(rs.getString("EMAIL"));
        dto.setSalario(rs.getDouble("SALARIO"));
        dto.setObs(rs.getString("OBS"));
    }

    /**
     *
     * Returns an array of Value Objects by fetching data from resultSet
     *
     * @param ResultSet rs
     * @return List<Funcionario>
     */
    protected List<Funcionario> fetchMultiResults(ResultSet rs) throws SQLException {
        List<Funcionario> resultList = new ArrayList();
        while (rs.next()) {
            Funcionario dto = new Funcionario();
            populateVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
}