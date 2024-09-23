package br.com.maximocolodetti.fdp.model;

public class Paciente extends Pessoa {
    private int idPaciente;
    private String observacoes;
    private boolean ativo;

    public Paciente(String nomePaciente, String celularUm, String celularDois, String observacoes) {
        super(nomePaciente, celularUm, celularDois);
        this.observacoes = observacoes;
    }

    public Paciente(String nomePaciente) {
        super(nomePaciente);
    }
    public Paciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }



    // Getters e Setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
