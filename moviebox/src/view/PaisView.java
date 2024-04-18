package view;

import controllers.PaisController;
import java.util.Scanner;

public class PaisView {

    private final PaisController CONTROLLER = new PaisController();
    private final MensagensView mensagem = new MensagensView();

    public void escolherAcao(Scanner input) {
        int escolha;

        mensagem.layoutMensagem("           Países - Cadastro/Edição            ");
        System.out.println(" Para CADASTRAR digite [1] ");
        System.out.println(" Para EDITAR digite [2] ");
        System.out.println("------------------------------------------------");
        System.out.print("Sua escolha: ");
        escolha = input.nextInt();

        if(escolha == 1) cadastro(input);
        else edicao(input);
    }

    public void cadastro(Scanner input) {

        mensagem.layoutMensagem("               Países - Cadastro               ");
        System.out.print(" Nome do país: ");
        input.nextLine();
        String nomePais = input.nextLine();

        System.out.println("----------------------------------------------");

        CONTROLLER.cadastrarPais(nomePais);
    }

    public void edicao(Scanner input) {

        mensagem.layoutMensagem("                Países - Edição                ");
        System.out.print(" ID do país que deseja editar: ");
        int idPais = input.nextInt();

        mensagem.limparTela(10);
        System.out.println("------------------------------------------------");
        System.out.print("Nome do país: ");
        input.nextLine();
        String nomePais = input.nextLine();

        System.out.println("----------------------------------------------");

        CONTROLLER.editarPais(idPais, nomePais);
    }
}
