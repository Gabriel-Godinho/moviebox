package view;

import controllers.DiretoresController;

import java.util.Scanner;

public class DiretoresView {

    private final DiretoresController controller = new DiretoresController();

    public void cadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("              Diretores - Cadastro              ");
        System.out.println("------------------------------------------------");
        System.out.println(" Preencha os dados do diretor: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do diretor: ");
            String nomeDiretor = input.nextLine();
        System.out.println("----------------------------------------------");
        System.out.print(" Nacionalidade: ");
            input.nextLine();
            String nacionalidade = input.nextLine();
        System.out.println("----------------------------------------------");

        input.close();

        controller.cadastrarDiretor(nomeDiretor, nacionalidade);
    }

    public void edicao() {
        Scanner input = new Scanner(System.in);

        int escolha;

        System.out.println("------------------------------------------------");
        System.out.println("          Diretores - Edição/Exclusão           ");
        System.out.println("------------------------------------------------");
        System.out.print(" ID do diretor que deseja editar/excluir: ");
            int idDiretor = input.nextInt();
        System.out.println("------------------------------------------------");
        System.out.println(" Para EDITAR digite [1] ");
        System.out.println(" Para EXCLUIR digite [2] ");
        System.out.print(" Sua escolha: ");
            escolha = input.nextInt();
        System.out.println("------------------------------------------------");

        if(escolha == 1) {
            System.out.println(" Preencha somente os campos que deseja editar e ");
            System.out.println(" marque o restante com [0]: ");
            System.out.println("----------------------------------------------");
            System.out.print(" Nome do diretor: ");
                input.nextLine();
                String nomeDiretor = input.nextLine();
            System.out.println("----------------------------------------------");
            System.out.print(" Nacionalidade: ");
                input.nextLine();
                String nacionalidade = input.nextLine();
            System.out.println("----------------------------------------------");

            controller.editarDiretor(idDiretor, nomeDiretor, nacionalidade);
        } else {
            controller.excluirDiretor(idDiretor);
        }
    }
}
