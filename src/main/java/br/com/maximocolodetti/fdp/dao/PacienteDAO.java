package br.com.maximocolodetti.fdp.dao;

import br.com.maximocolodetti.fdp.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {
    Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Paciente paciente) {
        String sql = """
          INSERT INTO PESSOA (NOME, CELULAR_UM, CELULAR_DOIS) VALUES (?, ?, ?);
          INSERT INTO PACIENTE (OBSERVACOES, ATIVO, ID_PESSOA_FK) VALUES (?, 1, SELECT SCOPE_IDENTITY() PESSOA),
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getCelularUm());
            preparedStatement.setString(3, paciente.getCelularDois());
            preparedStatement.setString(4, paciente.getObservacoes());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi criar novo paciente!" +  e.toString());
        }
    }
}
