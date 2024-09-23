package br.com.maximocolodetti.fdp.controller;

import br.com.maximocolodetti.fdp.dao.PacienteDAO;
import br.com.maximocolodetti.fdp.database.ConectaBancoDeDadosSQLServe;
import br.com.maximocolodetti.fdp.model.Paciente;

import java.sql.Connection;

public class PacienteController {
    ConectaBancoDeDadosSQLServe conectaBancoDeDadosSQLServe = new ConectaBancoDeDadosSQLServe();

    public void cadastrarPaciente(String nome, String celularUm, String celularDois, String observacoesPaciente) {
        Connection connection = conectaBancoDeDadosSQLServe.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(connection);

        Paciente paciente = new Paciente(nome, celularUm, celularDois, observacoesPaciente);
        pacienteDAO.inserir(paciente);
    }
}
