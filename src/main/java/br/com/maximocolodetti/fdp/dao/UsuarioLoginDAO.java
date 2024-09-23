package br.com.maximocolodetti.fdp.dao;

import br.com.maximocolodetti.fdp.model.UsuarioLogin;
import java.sql.*;

public class UsuarioLoginDAO {

    Connection connection;

    public UsuarioLoginDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(UsuarioLogin usuarioLogin) {
        String sql = """
          INSERT INTO USUARIO_LOGIN (USUARIO, SENHA) VALUES (?, ?);
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuarioLogin.getUsuario());
            preparedStatement.setString(2, usuarioLogin.getSenha());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi criar novo usuário!" +  e.toString());
        }
    }

    public int validar(UsuarioLogin usuarioLogin) {
        int idUsuarioLogin = -1;
        String sql = """
            SELECT COUNT(*) FROM USUARIO_LOGIN
            WHERE USUARIO = ? AND SENHA = ?
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuarioLogin.getUsuario());
            preparedStatement.setString(2, usuarioLogin.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.first()) {
                idUsuarioLogin = resultSet.getInt(1);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
            return idUsuarioLogin;
        } catch (SQLException e) {
            System.out.println("Erro ao validar usuário e senha!" + e.getMessage());
        }
        return idUsuarioLogin;
    }

}
