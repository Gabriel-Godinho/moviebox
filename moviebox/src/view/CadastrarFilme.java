package view;

import controllers.FilmesController;

import java.util.Scanner;

public class CadastrarFilme {

    private final FilmesController controller = new FilmesController();

    public void cadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("              Filmoteca - Cadastro              ");
        System.out.println("------------------------------------------------");
        System.out.println(" Preencha os dados do filme que deseja inserir: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do filme: ");
            String nomeFilme = input.next();
        System.out.println("----------------------------------------------");
        System.out.print(" Duração em minutos: ");
            int duracao = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" Ano de lançamento: ");
            int ano = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" Id do diretor: ");
            int idDiretor = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" ID do país de origem: ");
            int idPais = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" Sinopse: ");
            String sinopse = input.next();
        System.out.println("----------------------------------------------");

        controller.cadastrarFilme(nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
    }

    public void edicao() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("               Filmoteca - Edição               ");
        System.out.println("------------------------------------------------");
        System.out.print(" ID do filme que deseja editar: ");
            int idFilme = input.nextInt();
        System.out.println("------------------------------------------------");
        System.out.println(" Preencha somente os campos que deseja editar e ");
        System.out.println(" deixe o restante em branco usando ENTER: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do filme: ");
        String nomeFilme = input.next();
        System.out.println("----------------------------------------------");
        System.out.print(" Duração em minutos: ");
        int duracao = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" Ano de lançamento: ");
        int ano = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" Id do diretor: ");
        int idDiretor = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" ID do país de origem: ");
        int idPais = input.nextInt();
        System.out.println("----------------------------------------------");
        System.out.print(" Sinopse: ");
        String sinopse = input.next();
        System.out.println("----------------------------------------------");

        controller.editarFilme(idFilme, nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
    }

}
