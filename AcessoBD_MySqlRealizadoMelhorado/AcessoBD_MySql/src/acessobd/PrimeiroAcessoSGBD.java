/*
 * PrimeiroAcessoSGBD.java
 *
 * Created on 11 de Junho de 2005, 06:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package acessobd;

/**
 *
 * @author Java
 */
import java.net.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class PrimeiroAcessoSGBD {
    private static Connection con = null;
    //Connection con = null;
    /**
     * Creates a new instance of PrimeiroAcessoSGBD
     */
    public PrimeiroAcessoSGBD() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("teste de acesso ao banco de dados MySQL\n");
        PrimeiroAcessoSGBD bd = new PrimeiroAcessoSGBD();
        bd.estabelecerConexao();
        bd.menu();
        bd.encerrarConexao();
    }
    
    private void pesquisarDados() {
        Statement stm = null;
        String strSQL = "SELECT * FROM db_alunos.curso;";
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String linha = rs.getInt("ID") + " - " +
                        rs.getString("NOME") + " - " +
                        rs.getInt("CARGA_HORARIA");
                System.out.println("Curso:" +linha);
            }
        }catch(SQLException e) {
            System.out.println("SQL Exception... ");
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        System.out.println("Pesquisa realizada\n");
    }
    
    private void pesquisarDadosNome() {
        String pesquisar = JOptionPane.showInputDialog("Informe o nome para pesquisa:");
        Statement stm = null;
        String strSQL = "SELECT * FROM curso WHERE nome LIKE \"%"+ pesquisar + "%\";";
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(strSQL);
            while (rs.next()) {
                String linha = rs.getInt("ID") + " - " +
                        rs.getString("NOME") + " - " +
                        rs.getInt("CARGA_HORARIA");
                System.out.println("Curso:" +linha);
            }
        }catch(SQLException e) {
            System.out.println("SQL Exception... ");
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void estabelecerConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            final String url = "jdbc:mysql://localhost:3306/db_alunos";
            //final String url = "jdbc:mysql://localhost:3306/db_alunos?"
            //        + "useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String pwd = "";
            con = DriverManager.getConnection(url, user, pwd);
                
            System.out.println("Sucesso na conexao! \n");
        } catch(ClassNotFoundException e) {
            System.out.println("excecao ClassNotFound...");
            e.printStackTrace();
        }catch(SQLException e) {
            System.out.println("SQL Exception... ");
            e.printStackTrace();
        } 
    }
    
    private void encerrarConexao() {
        try {
            con.close();
        } catch(SQLException onConClose) {
            System.out.println("erro ao encerrar a conexao");
            onConClose.printStackTrace();
        }
    }

    private void inserirDados() {
        String nome = JOptionPane.showInputDialog("Informe o nome do curso");
        int ch = Integer.parseInt(JOptionPane.showInputDialog("Carga horaria: "));
        String sqlQuery = 
                "insert into db_alunos.curso (nome, carga_horaria) values ( " +
                            "'" + nome + "', " + ch + ");";

       Statement stm = null;
       
        try {
            stm = con.createStatement();
            stm.executeUpdate(sqlQuery);
            System.out.println("Inserido com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
        private void alterarDados() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do curso a ser alterado: "));
        String nome = JOptionPane.showInputDialog("Informe o novo nome do curso: ");
        int ch = Integer.parseInt(JOptionPane.showInputDialog("Informe a nova carga horaria: "));
        String sqlQuery = 
                "UPDATE db_alunos.curso SET nome='" + nome + "', carga_horaria=" + "'" + ch + "' WHERE id='"+id+"';";
       Statement stm = null;
       
        try {
            stm = con.createStatement();
            stm.executeUpdate(sqlQuery);
            System.out.println("Alterado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
        private void removerDados() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do curso a ser removido: "));
        String sqlQuery = 
                "DELETE FROM db_alunos.curso WHERE id='"+id+"';";
       Statement stm = null;
       
        try {
            stm = con.createStatement();
            stm.executeUpdate(sqlQuery);
            System.out.println("Removido com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void menu() {
        int menu = 0;
        
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n 1- Inserir \n 2- Alterar \n 3- Remover \n 4-Listar todos \n 5- Pesquisar por nome \n 0- Sair"));
           switch (menu) {
               case 1:
                   this.inserirDados();
                   break;
               case 2:
                   this.alterarDados();
                   break;
               case 3:
                   this.removerDados();
                   break;
               case 4:
                   this.pesquisarDados();
                   break;
               case 5:
                   this.pesquisarDadosNome();
                   break;
               case 0:
                   System.out.println("Você saiu do programa.");
                   System.exit(0);
                   break;
               default:
           }
        } while (menu != 0);
    }
}
