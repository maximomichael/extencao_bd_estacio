package br.com.maximocolodetti.fdp.controller;

import br.com.maximocolodetti.fdp.dao.AgendaDAO;
import br.com.maximocolodetti.fdp.database.ConectaBancoDeDadosSQLServe;
import br.com.maximocolodetti.fdp.model.Agenda;
import br.com.maximocolodetti.fdp.model.Paciente;
import br.com.maximocolodetti.fdp.model.Profissional;

import java.sql.Connection;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgendaController {

    ConectaBancoDeDadosSQLServe conectaBancoDeDadosSQLServe = new ConectaBancoDeDadosSQLServe();

    public void cadastrarAgendamento(String dataConsulta, String horaInicio, String horaFim, String observacoes, String idPaciente, String idProfissional) throws ParseException {
        Connection connection = conectaBancoDeDadosSQLServe.conectar();
        AgendaDAO usuarioLoginDAO = new AgendaDAO(connection);
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
        Agenda agenda = new Agenda(formatoData.parse(dataConsulta), (Time) formatohora.parse(horaInicio), (Time) formatohora.parse(horaInicio), observacoes, new Profissional(Integer.parseInt(idProfissional)) , new Paciente(Integer.parseInt(idPaciente)));
        usuarioLoginDAO.inserir(agenda);
    }
}
