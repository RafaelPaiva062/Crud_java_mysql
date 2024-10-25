package br.com.loja.dal;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModulloConexao {
    public static void main(String [] args){
        String url =  "jdbc:mysql://localhost:3306/dblojaetec";
        String user = "root";
        String password ="Prof@dm1n";

        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from usuarios");
            while (resultSet.next()){
                System.out.println(resultSet.getString("login"));
                System.out.println(resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}