package br.com.maximocolodetti.fdp.model;

import java.util.Date;

public class Despesa {
    private int idDespesa;
    private Date dataLancamento;
    private double valorDespesa;
    private String descricao;
    private String observacoes;

    public Despesa(Date dataLancamento, double valorDespesa, String descricao, String observacoes) {
        this.dataLancamento = dataLancamento;
        this.valorDespesa = valorDespesa;
        this.descricao = descricao;
        this.observacoes = observacoes;
    }
    private Profissional profissional;

    // Getters e Setters
    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
