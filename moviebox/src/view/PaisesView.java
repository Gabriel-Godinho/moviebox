package view;

import controllers.PaisesController;
import java.util.Scanner;

public class PaisesView {

    private final PaisesController CONTROLLER = new PaisesController();

    public void cadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("                Países - Cadastro               ");
        System.out.println("------------------------------------------------");
        System.out.print("Nome do país: ");
        String nomePais = input.nextLine();

        System.out.println("----------------------------------------------");

        CONTROLLER.cadastrarPais(nomePais);

        input.close();
    }

    public void edicao() {
        Scanner input = new Scanner(System.in);

        int escolha;

        System.out.println("------------------------------------------------");
        System.out.println("            Países - Edição/Exclusão            ");
        System.out.println("------------------------------------------------");
        System.out.print("ID do país que deseja editar/excluir: ");
        int idPais = input.nextInt();

        System.out.println("------------------------------------------------");
        System.out.println(" Para EDITAR digite [1] ");
        System.out.println(" Para EXCLUIR digite [2] ");
        System.out.print("Sua escolha: ");
        escolha = input.nextInt();

        System.out.println("------------------------------------------------");

        if (escolha == 1) {
            System.out.print("Nome do país: ");
            String nomePais = input.nextLine();

            System.out.println("----------------------------------------------");

            CONTROLLER.editarPais(idPais, nomePais);
        } else {
            CONTROLLER.excluirPais(idPais);
        }

        input.close();
    }

}
