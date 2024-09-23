package br.com.maximocolodetti.fdp.dao;

import br.com.maximocolodetti.fdp.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CheckoutDAO {
    Connection connection;

    public CheckoutDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Checkout checkout) {
        String sql = """
            INSERT INTO CHECKOUT (DATA_FECHAMENTO, VALOR_DESCONTO, VALOR_TOTAL, VALOR_COMISSAO_CLINICA, OBSERVACOES, ID_AGENDAMENTO_FK) VALUES (?, ?, ?, ?, ?, ?);
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) checkout.getDataFechamento());
            preparedStatement.setDouble(2, checkout.getValorDesconto());
            preparedStatement.setDouble(3, checkout.getValorTotal());
            preparedStatement.setDouble(4, checkout.getValorComissaoClinica());
            preparedStatement.setString(5, checkout.getObservacoes());
            preparedStatement.setInt(6, checkout.getAgendamento().getIdAgendamento());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fazer checkout!" +  e.toString());
        }
    }

    public List<Checkout> listarCheckout() {
        List<Checkout> listaCheckout = new ArrayList<>();
        String sql = """
          SELECT
            CKT.DATA_FECHAMENTO,
            CKT.VALOR_DESCONTO,
            CKT.VALOR_TOTAL,
            CKT.VALOR_COMISSAO_CLINICA,
            CKT.OBSERVACOES,
            PES.NOME
          FROM CHECKOUT CKT
          INNER JOIN AGENDA AGD ON CKT.ID_AGENDAMENTO_FK = AGD.ID_AGENDAMENTO
          INNER JOIN PACIENTE PCT ON PCT.ID_PACIENTE = AGD.ID_PACIENTE_FK
          INNER JOIN PESSOA PES ON PES.ID_PESSOA = PCT.ID_PESSOA_FK
          ORDER BY CKT.DATA_FECHAMENTO DESC;
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date dataFechamento = resultSet.getDate("CKT.DATA_FECHAMENTO");
                double valorDesconto = resultSet.getDouble("CKT.VALOR_DESCONTO");
                double valorTotal = resultSet.getDouble("CKT.VALOR_TOTAL");
                double valorComissaoClinica = resultSet.getDouble("CKT.VALOR_COMISSAO_CLINICA");
                String observacao = resultSet.getString("CKT.OBSERVACOES");
                String nomePaciente = resultSet.getString("PES.NOME");
                Checkout checkout = new Checkout(dataFechamento, valorDesconto, valorTotal, valorComissaoClinica, observacao, new Agenda(new Paciente(nomePaciente)));
                listaCheckout.add(checkout);
            }
            connection.close();
            return listaCheckout;
        } catch (SQLException e) {
            System.out.println("Não foi possivel listar agendamentos!" +  e.toString());
        }
        return listaCheckout;
    }
}
