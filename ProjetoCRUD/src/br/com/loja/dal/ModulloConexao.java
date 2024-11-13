package br.com.loja.dal;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModulloConexao {
    private static final String url = "jdbc:mysql://localhost:3306/dblojaetec?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "Prof@dm1n";

    public static Connection connection() throws SQLException {
        try {
            // Registra o driver JDBC manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado!", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String [] args){
        // Listar drivers disponíveis no classpath


        try{
            Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from usuarios");
            while (resultSet.next()){
                System.out.println(resultSet.getString("usuario"));
                System.out.println(resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String testConnection() {
        try (Connection connection = connection()) {
            return "Conexão bem-sucedida!";
        } catch (SQLException e) {
            return "Erro de conexão: " + e.getMessage();
        }
    }
}