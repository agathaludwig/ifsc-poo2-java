/*
 * Conexao.java
 *
 * Created on 11 de Junho de 2005, 19:53
 */

package net.softlages.db;

/**
 *
 * @author Marcos Pisching
 */
import java.sql.*;


public class ConexaoPostegreSql {
    
    //atributo con da classe Connection: para estabelcer a conexao com o SGBD
    private static Connection con;
    //atributo stm da classe Statement: para elaborar as expressoes SQL
    private static Statement stm;
    
    /** Creates a new instance of Conexao */
    public ConexaoPostegreSql() {
    }
    
    public static void conectar() {
        if (con == null) {
            String driver = "jdbc:postgresql:";
            String bancoDados = "//localhost:5432/nomeDoBancoDeDados";
            String user = "postgres";
            String pass = "postgres";

            try {
                //Acessar a classe FBDriver
                Class.forName("org.postgresql.Driver");
                //estabelecimento da conexao atraves da invocacao do metodo getConnection
                con = DriverManager.getConnection(driver + bancoDados, user, pass);
                System.out.println("CONEXÃO REALIZADA COM SUCESSO!");
                //habilitando stm para execucao de expressoes SQL
                stm = con.createStatement();            
            }
            catch (ClassNotFoundException e) {
                System.out.println("Impossível estabelecer a conexão");
                System.out.println("Exceção ClassNotFound !");
            }
            catch (SQLException e) {
                System.out.println("Impossível estabelecer a conexão");
                System.out.println("Exceção SQL ! Conexão não pode ser realizada");
            }
            }
    }
    
    public static void encerrar() {
        try {
            con.close();    
        }
        catch (SQLException e) {
            System.out.println("Exceção SQL !");
        }
        
    }
    
    public static Statement getStm() {
        return stm;
    }
    
    public static Connection getCon() {
        return con;
    }
    
    public static void setStm(Statement s) {
        stm = s;
    }
    
    public static void setCon(Connection c) {
        con = c;
    }
    
    public static void commit() {
        try {
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void rollback() {
        try {
            con.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
