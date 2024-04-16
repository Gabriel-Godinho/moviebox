package view;

import controllers.FilmesController;

import java.util.Scanner;

public class FilmesView {

    private final FilmesController CONTROLLER = new FilmesController();

    public void cadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("                Filmes - Cadastro               ");
        System.out.println("------------------------------------------------");
        System.out.println(" Preencha os dados do filme que deseja inserir: ");
        System.out.println("----------------------------------------------");
        System.out.print("Nome do filme: ");
        String nomeFilme = input.nextLine();

        System.out.println("----------------------------------------------");
        System.out.print("Duração em minutos: ");
        int duracao = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print("Ano de lançamento: ");
        int ano = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print("Id do diretor: ");
        int idDiretor = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print("ID do país de origem: ");
        int idPais = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print("Sinopse: ");
        String sinopse = input.nextLine();

        System.out.println("----------------------------------------------");

        CONTROLLER.cadastrarFilme(nomeFilme, duracao, ano, idDiretor, idPais, sinopse);

        input.close();
    }

    public void edicao() {
        int escolha = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("            Filmes - Edição/Exclusão            ");
        System.out.println("------------------------------------------------");
        System.out.print(" ID do filme que deseja editar/excluir: ");
        int idFilme = input.nextInt();

        System.out.println("------------------------------------------------");
        System.out.println(" Para EDITAR digite [1] ");
        System.out.println(" Para EXCLUIR digite [2] ");
        System.out.print("Sua escolha: ");
        escolha = input.nextInt();

        System.out.println("------------------------------------------------");

        if (escolha == 1) {
            System.out.println(" Preencha somente os campos que deseja editar e ");
            System.out.println(" marque o restante com [0]: ");
            System.out.println("----------------------------------------------");
            System.out.print("Nome do filme: ");
            String nomeFilme = input.nextLine();

            System.out.println("----------------------------------------------");
            System.out.print("Duração em minutos: ");
            int duracao = input.nextInt();

            System.out.println("----------------------------------------------");
            System.out.print("Ano de lançamento: ");
            int ano = input.nextInt();

            System.out.println("----------------------------------------------");
            System.out.print("Id do diretor: ");
            int idDiretor = input.nextInt();

            System.out.println("----------------------------------------------");
            System.out.print("ID do país de origem: ");
            int idPais = input.nextInt();

            System.out.println("----------------------------------------------");
            System.out.print("Sinopse: ");
            String sinopse = input.nextLine();

            System.out.println("----------------------------------------------");

            CONTROLLER.editarFilme(idFilme, nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
        } else {
            CONTROLLER.excluirFilme(idFilme);
        }

        input.close();
    }

}
