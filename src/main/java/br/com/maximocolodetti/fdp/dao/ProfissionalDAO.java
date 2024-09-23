package br.com.maximocolodetti.fdp.dao;

import br.com.maximocolodetti.fdp.model.Profissional;
import br.com.maximocolodetti.fdp.model.UsuarioLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfissionalDAO {

    Connection connection;

    public ProfissionalDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Profissional profissional) {
        String sql = """
          INSERT INTO PESSOA (NOME, CELULAR_UM, CELULAR_DOIS) VALUES (?, ?, ?);
          INSERT INTO PROFISSIONAL (COMISSAO_CLINICA, ATIVO, ID_PESSOA_FK) VALUES (?, 1, SELECT SCOPE_IDENTITY() PESSOA);
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, profissional.getNome());
            preparedStatement.setString(2, profissional.getCelularUm());
            preparedStatement.setString(3, profissional.getCelularDois());
            preparedStatement.setDouble(4, profissional.getComissaoClinica());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi criar novo profissional!" +  e.toString());
        }
    }

}
