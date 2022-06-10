
package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class Conexao {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cadastros";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "murillo12";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
            
    public static Connection iniciarConexao(){
        try{
            System.err.println("Conectando com o banco de dados");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            System.out.println("Conectado");
        }catch (SQLException ex){
            System.err.println("Problema com a conexao");
            ex.printStackTrace();
        }
        return connection;
    }  
      
    
        public static void fecharConexao(){
            try{
                System.out.println("Fechando a conexao com o banco de dados");
                statement.close();
                connection.close();
                System.out.println("Conexao Fechada");
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            
        }
    } 
        
    
    

