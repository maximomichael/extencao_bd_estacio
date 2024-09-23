package br.com.maximocolodetti.fdp.dao;

import br.com.maximocolodetti.fdp.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    Connection connection;

    public DespesaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Despesa despesa) {
        String sql = """
            INSERT INTO DESPESA (DATA_LANCAMENTO, VALOR_DESPESA, DESCRICAO, OBSERVACOES, ID_PROFISSIONAL_FK) VALUES (?, ?, ?, ?, ?);
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) despesa.getDataLancamento());
            preparedStatement.setDouble(2, despesa.getValorDespesa());
            preparedStatement.setString(3, despesa.getDescricao());
            preparedStatement.setString(4, despesa.getObservacoes());
            preparedStatement.setInt(4, despesa.getProfissional().getIdProfissional());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel cadastrar despesa!" +  e.toString());
        }
    }

    public List<Despesa> listarDespesas() {
        List<Despesa> listaDespesas = new ArrayList<>();
        String sql = """
            SELECT
                DES.DATA_LANCAMENTO,
                DES.VALOR_DESPESA,
                DES.DESCRICAO,
                DES.OBSERVACOES
            FROM DESPESA DES
            ORDER BY DES.DATA_LANCAMENTO DESC;
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date dataFechamento = resultSet.getDate("DATA_LANCAMENTO");
                double valorDesconto = resultSet.getDouble("VALOR_DESPESA");
                String descricao = resultSet.getString("DESCRICAO");
                String observacao = resultSet.getString("OBSERVACOES");
                Despesa despesa = new Despesa(dataFechamento, valorDesconto, descricao, observacao);
                listaDespesas.add(despesa);
            }
            connection.close();
            return listaDespesas;
        } catch (SQLException e) {
            System.out.println("Não foi possivel listar despesas!" +  e.toString());
        }
        return listaDespesas;
    }

}
