package br.com.maximocolodetti.fdp.model;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String celularUm;
    private String celularDois;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nomePaciente, String celularUm, String celularDois) {
        this.nome = nomePaciente;
        this.celularUm = celularUm;
        this.celularDois = celularDois;
    }

    public Pessoa() {

    }

    // Getters e Setters
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelularUm() {
        return celularUm;
    }

    public void setCelularUm(String celularUm) {
        this.celularUm = celularUm;
    }

    public String getCelularDois() {
        return celularDois;
    }

    public void setCelularDois(String celularDois) {
        this.celularDois = celularDois;
    }
}
