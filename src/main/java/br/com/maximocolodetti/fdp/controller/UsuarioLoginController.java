package br.com.maximocolodetti.fdp.controller;

import br.com.maximocolodetti.fdp.dao.UsuarioLoginDAO;
import br.com.maximocolodetti.fdp.database.ConectaBancoDeDadosSQLServe;
import br.com.maximocolodetti.fdp.model.UsuarioLogin;

import java.sql.Connection;

public class UsuarioLoginController {
    public static int idUsuario;
    ConectaBancoDeDadosSQLServe conectaBancoDeDadosSQLServe = new ConectaBancoDeDadosSQLServe();

    public void cadastrarUsuario(String usuario, String senha){
        Connection connection = conectaBancoDeDadosSQLServe.conectar();
        UsuarioLoginDAO usuarioLoginDAO = new UsuarioLoginDAO(connection);
        UsuarioLogin usuarioLogin = new UsuarioLogin(usuario, senha);
        usuarioLoginDAO.inserir(usuarioLogin);
        validarLogin(usuario, senha);
    }

    public void validarLogin(String usuario, String senha){
        UsuarioLoginDAO usuarioLoginDAO = new UsuarioLoginDAO(conectaBancoDeDadosSQLServe.conectar());
        UsuarioLogin usuarioLogin = new UsuarioLogin(usuario, senha);
        idUsuario = usuarioLoginDAO.validar(usuarioLogin);
    }
}
