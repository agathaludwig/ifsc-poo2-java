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

public class Conexao {

    //atributo con da classe Connection: para estabelcer a conexao com o SGBD
    private static Connection con;
   
    /**
     * Creates a new instance of Conexao
     */
    public Conexao() {
    }

    public static void conectar() {
        if (con == null) {
            String driver = "jdbc:mysql:";
            String bancoDados = "//localhost:3306/db_funcionario";
            String user = "root";
            String pass = "1234";

            try {
                //Acessar a classe FBDriver
                Class.forName("com.mysql.jdbc.Driver");
                //estabelecimento da conexao atraves da invocacao do metodo getConnection
                con = DriverManager.getConnection(driver + bancoDados, user, pass);
                System.out.println("CONEXÃO REALIZADA COM SUCESSO!");
            } catch (ClassNotFoundException e) {
                System.out.println("Impossível estabelecer a conexão");
                System.out.println("Exceção ClassNotFound !");
            } catch (SQLException e) {
                System.out.println("Exceção SQL ! Conexão não pode ser realizada");
            }
        }
    }

    public static void encerrar() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Exceção SQL !");
        }

    }

    public static Connection getCon() {
        if (con == null) {
            conectar();
        }
        return con;
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
