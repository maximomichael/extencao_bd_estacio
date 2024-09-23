package br.com.maximocolodetti.fdp.model;

import java.sql.Time;
import java.util.Date;

public class Agenda {
    private int idAgendamento;
    private Date dataMarcacao;
    private Date dataAgendamento;
    private Time horaInicio;
    private Time horaFinal;
    private String statusAtual;
    private String observacoes;
    private Profissional profissional;
    private Paciente paciente;

    public Agenda(Date dataMarcacao, Date dataAgendamento, Time horaInicio, Time horaFinal, String statusAtual, String observacoes, Paciente paciente) {
        this.dataMarcacao = dataMarcacao;
        this.dataAgendamento = dataAgendamento;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.statusAtual = statusAtual;
        this.observacoes = observacoes;
        this.paciente = paciente;
    }

    public Agenda(Date dataAgendamento, Time horaInicio, Time horaFinal, String observacoes, Profissional profissional, Paciente paciente) {
        this.dataAgendamento = dataAgendamento;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.observacoes = observacoes;
        this.profissional = profissional;
        this.paciente = paciente;
    }

    public Agenda(Paciente paciente) {
        this.paciente = paciente;
    }

    // Getters e Setters
    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setStatusAtual(String statusAtual) {
        this.statusAtual = statusAtual;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
