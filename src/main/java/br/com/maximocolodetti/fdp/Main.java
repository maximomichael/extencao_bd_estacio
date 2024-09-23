package br.com.maximocolodetti.fdp;

import br.com.maximocolodetti.fdp.controller.MenuController;
import br.com.maximocolodetti.fdp.service.Manipuladores;
import br.com.maximocolodetti.fdp.view.UsuarioView;

public class Main {



    public static void main(String[] args) {

        MenuController.chamarMenuPrincipal();
    }

    void CadastrarUsuario() {
        UsuarioView.cadastrar();
        Manipuladores.limparConsole();
    }
}

