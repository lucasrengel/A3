package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe responsável por gerenciar a conexão com o banco de dados MySQL.
public class Conexao {

    //metodo para a conexao do banco de dados
    public static Connection getConexao() {

        Connection connection = null;//instancia da conexao

        try {
            //carregando o driver jdbc
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            //configuracao do caminho do mySQL
            String server = "localhost";
            String database = "db_a3";
            String url = "jdbc:mysql://" + server + ":3306/" + database;
            String user = "root";
            String password = "1234";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NAO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver nao encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }

    }
}
