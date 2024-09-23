package br.com.maximocolodetti.fdp.view;

import br.com.maximocolodetti.fdp.controller.PacienteController;

import java.util.Scanner;

public class PacienteView {

    public static void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CADASTRAR PACIENTE");


        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o celular 1: ");
        String celularUm = scanner.nextLine();

        System.out.print("Digite o celular 2: ");
        String celularDois = scanner.nextLine();

        System.out.print("Observaçoes: ");
        String observacoesPaciente = scanner.nextLine();

        PacienteController pacienteController = new PacienteController();
        pacienteController.cadastrarPaciente(nome, celularUm, celularDois, observacoesPaciente);

        scanner.close();
    }
}
