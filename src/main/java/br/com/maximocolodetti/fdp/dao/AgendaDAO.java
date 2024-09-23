package br.com.maximocolodetti.fdp.dao;

import br.com.maximocolodetti.fdp.model.Agenda;
import br.com.maximocolodetti.fdp.model.Paciente;
import br.com.maximocolodetti.fdp.model.UsuarioLogin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    Connection connection;

    public AgendaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Agenda agenda) {
        String sql = """
          INSERT INTO AGENDA (DATA_MARCACAO, DATA_AGENDAMENTO, HORA_INICIO, HORA_FINAL, STATUS_ATUAL, OBSERVACOES, ID_PROFISSIONAL_FK, ID_PACIENTE_FK) VALUES (?, ?, ?, ?, 'A', ?, ?, ?);
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, (Date) agenda.getDataAgendamento());
            preparedStatement.setDate(2, (Date) agenda.getHoraInicio());
            preparedStatement.setDate(3, (Date) agenda.getHoraFinal());
            preparedStatement.setString(4, agenda.getObservacoes());
            preparedStatement.setInt(5, agenda.getProfissional().getIdProfissional());
            preparedStatement.setInt(6, agenda.getPaciente().getIdPaciente());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel agendar!" +  e.toString());
        }
    }

    public List<Agenda> listar() {

        List<Agenda> listaAgendamentos = new ArrayList<>();
        String sql = """
            SELECT
                PCT.NOME AS NOME_PACIENTE,
                AGD.DATA_MARCACAO,
                AGD.DATA_AGENDAMENTO,
                AGD.HORA_INICIO,
                AGD.HORA_FINAL,
                AGD.STATUS_ATUAL,
                AGD.OBSERVACOES,
            FROM AGENDA AGD
            ORDER BY AGD.DATA_AGENDAMENTO, AGD.HORA_INICIO;
        """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nomePaciente = resultSet.getString("NOME_PACIENTE");
                Date dataMarcacao = resultSet.getDate("DATA_MARCACAO");
                Date dataAgendamento = resultSet.getDate("DATA_AGENDAMENTO");
                Time horaInicio = resultSet.getTime("HORA_INICIO");
                Time horaFinal = resultSet.getTime("HORA_FINAL");
                String statusAtual = resultSet.getString("STATUS_ATUAL");
                String observacoes = resultSet.getString("OBSERVACOES");

                Agenda agenda = new Agenda(dataMarcacao, dataAgendamento, horaInicio, horaFinal, statusAtual, observacoes, new Paciente(nomePaciente));
                listaAgendamentos.add(agenda);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
            return listaAgendamentos;
        } catch (SQLException e) {
            System.out.println("Erro ao validar usuário e senha!" + e.getMessage());
        }
        return listaAgendamentos;
    }
}
