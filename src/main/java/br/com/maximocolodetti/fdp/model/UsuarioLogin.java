package br.com.maximocolodetti.fdp.model;


public class UsuarioLogin {
    private int idUsuarioLogin;
    private String usuario;
    private String senha;

    public UsuarioLogin(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    UsuarioLogin(int idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    // Getters e Setters
    public int getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(int idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
