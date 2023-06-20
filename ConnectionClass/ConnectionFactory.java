/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Interessante perceber que quando as funções de fechamento de conexão foram criadas, foi utilizada uma sobrecarga de métodos
public class ConnectionFactory {
    //Criando aqui os atributos da conexão, como login e uma eventual senha do banco de dados
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/petshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    //Função para conseguir abrir a conexão, tendo um cuidado com a exceção para que ela cuide de eventuais erros
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    // Função para fechar a conexão, somente a conexão em si
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Função para fechar a conexão, dessa vez junto com os statements, que são os "registros"
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Função para fechar a conexão, os "registros" e o resultado da(s) ação(ões) que foi(foram) feita(s) dentro do banco de dados
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

