package view;

import controllers.DiretoresController;

import java.util.Scanner;

public class DiretoresView {

    private final DiretoresController CONTROLLER = new DiretoresController();
    private final MensagensView mensagem = new MensagensView();

    public void escolherAcao(Scanner input) {
        int escolha;

        mensagem.layoutMensagem("          Diretores - Cadastro/Edição          ");
        System.out.println(" Para CADASTRAR digite [1] ");
        System.out.println(" Para EDITAR digite [2] ");
        System.out.println("------------------------------------------------");
        System.out.print("Sua escolha: ");
        escolha = input.nextInt();

        if(escolha == 1) cadastro(input);
        else edicao(input);
    }

    public void cadastro(Scanner input) {

        mensagem.layoutMensagem("             Diretores - Cadastro              ");
        System.out.println(" Preencha os dados do diretor: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do diretor: ");
        String nomeDiretor = input.nextLine();

        System.out.println("----------------------------------------------");
        System.out.print(" ID do país de origem: ");
        int idPais = input.nextInt();

        System.out.println("----------------------------------------------");

        CONTROLLER.cadastrarDiretor(nomeDiretor, idPais);
    }

    public void edicao(Scanner input) {


        mensagem.layoutMensagem("              Diretores - Edição               ");
        System.out.print(" ID do diretor que deseja editar: ");
        int idDiretor = input.nextInt();

        mensagem.limparTela(10);

        System.out.println(" Preencha somente os campos que deseja editar e ");
        System.out.println(" marque o restante com [0]: ");
        System.out.println("----------------------------------------------");
        System.out.print("Nome do diretor: ");
            String nomeDiretor = input.nextLine();
        System.out.println("----------------------------------------------");
        System.out.print("ID do país de origem: ");
            int idPais = input.nextInt();
        System.out.println("----------------------------------------------");

        CONTROLLER.editarDiretor(idDiretor, nomeDiretor, idPais);
    }

}
