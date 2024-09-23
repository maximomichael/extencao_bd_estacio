package br.com.maximocolodetti.fdp.model;

public class Profissional extends Pessoa{
    private int idProfissional;
    private double comissaoClinica;
    private boolean ativo;

    public Profissional(String nome) {
        super(nome);
    }

    public Profissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }


    // Getters e Setters
    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public double getComissaoClinica() {
        return comissaoClinica;
    }

    public void setComissaoClinica(double comissaoClinica) {
        this.comissaoClinica = comissaoClinica;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
