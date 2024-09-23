package br.com.maximocolodetti.fdp.view;

import br.com.maximocolodetti.fdp.controller.AgendaController;
import br.com.maximocolodetti.fdp.controller.PacienteController;

import java.util.Scanner;

public class AgendaView {
    public static void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CADASTRAR AGENDAMENTO");


        System.out.print("Data consulta (00/00/0000): ");
        String dataConsulta = scanner.nextLine();

        System.out.print("Hora inicío (00:00): ");
        String horaInicio = scanner.nextLine();

        System.out.print("Hora fim (00:00): ");
        String horaFim = scanner.nextLine();

        System.out.print("Observaçoes: ");
        String observacoes = scanner.nextLine();

        AgendaController agendaController = new AgendaController();
        agendaController.cadastrarAgendamento(dataConsulta, horaInicio, horaFim, observacoes);

        scanner.close();
    }
}
