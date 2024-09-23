package br.com.maximocolodetti.fdp.view;

import br.com.maximocolodetti.fdp.controller.UsuarioLoginController;
import java.util.Scanner;

public class UsuarioView {
    public static void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CADASTRAR USUÁRIO");

        System.out.print("EMAIL: ");
        String usuario = scanner.nextLine();

        System.out.print("SENHA: ");
        String senha = scanner.nextLine();

        UsuarioLoginController usuarioLoginController = new UsuarioLoginController();
        usuarioLoginController.cadastrarUsuario(usuario, senha);

        scanner.close();
    }

    public void entrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTRAR");

        System.out.print("EMAIL: ");
        String usuario = scanner.nextLine();

        System.out.print("SENHA: ");
        String senha = scanner.nextLine();

        UsuarioLoginController usuarioLoginController = new UsuarioLoginController();
        usuarioLoginController.validarLogin(usuario, senha);

        scanner.close();
    }
}
