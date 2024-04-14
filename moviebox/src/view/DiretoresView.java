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
        String nomeDiretor = input.next();
        System.out.println("----------------------------------------------");
        System.out.print(" Nacionalidade: ");
            String nacionalidade = input.next();
        System.out.println("----------------------------------------------");

        controller.cadastrarDiretor(nomeDiretor, nacionalidade);
    }

    public void edicao() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("               Diretores - Edição               ");
        System.out.println("------------------------------------------------");
        System.out.print(" ID do diretor que deseja editar: ");
        int idDiretor = input.nextInt();
        System.out.println("------------------------------------------------");
        System.out.println(" Preencha somente os campos que deseja editar e ");
        System.out.println(" deixe o restante em branco usando ENTER: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do diretor: ");
            String nomeDiretor = input.next();
        System.out.println("----------------------------------------------");
        System.out.print(" Nacionalidade: ");
            String nacionalidade = input.next();
        System.out.println("----------------------------------------------");

        controller.editarDiretor(idDiretor, nomeDiretor, nacionalidade);
    }

}
