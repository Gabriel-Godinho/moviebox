package view;

import controllers.DiretoresController;
import controllers.PaisesController;

import java.util.Scanner;

public class PaisesView {

    private final PaisesController controller = new PaisesController();

    public void cadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("                Países - Cadastro               ");
        System.out.println("------------------------------------------------");
        System.out.print(" Nome do país: ");
            String nomePais = input.next();
        System.out.println("----------------------------------------------");

        controller.cadastrarPais(nomePais);
    }

    public void edicao() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("                 Países - Edição                ");
        System.out.println("------------------------------------------------");
        System.out.print(" ID do país que deseja editar: ");
            int idPais = input.nextInt();
        System.out.println("------------------------------------------------");
        System.out.print(" Nome do país: ");
            String nomePais = input.next();
        System.out.println("----------------------------------------------");

        controller.editarPais(idPais, nomePais);
    }

}
