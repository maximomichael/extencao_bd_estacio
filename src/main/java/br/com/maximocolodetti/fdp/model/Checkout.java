package br.com.maximocolodetti.fdp.model;

import java.util.Date;

public class Checkout {
    private int idCheckout;
    private Date dataFechamento;
    private double valorDesconto;
    private double valorTotal;
    private double valorComissaoClinica;
    private String observacoes;
    private Agenda agendamento;

    public Checkout(Date dataFechamento, double valorDesconto, double valorTotal, double valorComissaoClinica, String observacao, Agenda agenda) {
        this.dataFechamento = dataFechamento;
        this.valorDesconto = valorDesconto;
        this.valorTotal = valorTotal;
        this.valorComissaoClinica = valorComissaoClinica;
        this.observacoes = observacao;
        this.agendamento = agenda;
    }

    // Getters e Setters
    public int getIdCheckout() {
        return idCheckout;
    }

    public void setIdCheckout(int idCheckout) {
        this.idCheckout = idCheckout;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorComissaoClinica() {
        return valorComissaoClinica;
    }

    public void setValorComissaoClinica(double valorComissaoClinica) {
        this.valorComissaoClinica = valorComissaoClinica;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Agenda getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agenda agendamento) {
        this.agendamento = agendamento;
    }
}
