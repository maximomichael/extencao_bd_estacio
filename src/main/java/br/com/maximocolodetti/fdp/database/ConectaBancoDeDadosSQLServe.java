package br.com.maximocolodetti.fdp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBancoDeDadosSQLServe {
    private Connection connection;
    public static String url = "jdbc:sqlserver://localhost:1433;databaseName=AGENDA_FINANCEIRA_PODOLOGIA_EXTENSAO;user=sa;password=root;trustServerCertificate=true";

    public Connection conectar() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }
}
