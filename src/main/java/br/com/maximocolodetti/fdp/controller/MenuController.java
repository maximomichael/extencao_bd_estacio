package br.com.maximocolodetti.fdp.controller;

import br.com.maximocolodetti.fdp.model.Paciente;

import java.util.Scanner;

public class MenuController {

    public static void chamarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            imprimirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            executarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    static void imprimirMenu() {
        System.out.print("!:::AGENDA FINANCEIRA PODOLOGICA:::!");
        System.out.print("1 - CADASTRAR PACIENTE");
        System.out.print("2 - CADASTRAR AGENDAMENTO");
        System.out.print("3 - VISUALIZAR AGENDAMENTOS");
        System.out.print("4 - VISUALIZAR CHECKOUT");
        System.out.print("0 -SAIR");
    }

    static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Cadastrar Paciente...");

                break;
            case 2:
                System.out.println("Cadastrar Agendamento...");
                // Lógica para cadastrar agendamento
                break;
            case 3:
                System.out.println("Visualizar Agendamentos...");
                // Lógica para visualizar agendamentos
                break;
            case 4:
                System.out.println("Visualizar Checkout...");
                // Lógica para visualizar checkout
                break;
            case 0:
                // Sai do menu
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }


}
