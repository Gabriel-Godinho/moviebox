package view;

import controllers.FilmesController;

import java.util.Scanner;

public class FilmesView {

    private final FilmesController CONTROLLER = new FilmesController();
    private final MensagensView mensagem = new MensagensView();

    public void escolherAcao(Scanner input) {
        int escolha;

        mensagem.layoutMensagem("           Filmes - Cadastro/Edição            ");
        System.out.println(" Para CADASTRAR digite [1] ");
        System.out.println(" Para EDITAR digite [2] ");
        System.out.println("------------------------------------------------");
        System.out.print("Sua escolha: ");
        escolha = input.nextInt();

        if(escolha == 1) cadastro(input);
        else edicao(input);
    }

    private void cadastro(Scanner input) {

        mensagem.layoutMensagem("               Filmes - Cadastro               ");
        System.out.println(" Preencha os dados do filme que deseja inserir: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do filme: ");
        String nomeFilme = input.nextLine();

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
        String sinopse = input.nextLine();

        System.out.println("----------------------------------------------");

        CONTROLLER.cadastrarFilme(nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
    }

    public void edicao(Scanner input) {

        mensagem.limparTela(10);
        mensagem.layoutMensagem("               Filmes - Edição                ");
        System.out.print(" ID do filme que deseja editar: ");
        int idFilme = input.nextInt();

        mensagem.limparTela(10);
        System.out.println("------------------------------------------------");
        System.out.println(" Preencha somente os campos que deseja editar e ");
        System.out.println(" marque o restante com [0]: ");
        System.out.println("----------------------------------------------");
        System.out.print(" Nome do filme: ");
        input.next();
        String nomeFilme = input.nextLine();

        System.out.println("----------------------------------------------");
        System.out.print(" Duração em minutos: ");
        int duracao = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print(" Ano de lançamento: ");
        int ano = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print(" ID do diretor: ");
        int idDiretor = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print(" ID do país de origem: ");
        int idPais = input.nextInt();

        System.out.println("----------------------------------------------");
        System.out.print(" Sinopse: ");
        input.next();
        String sinopse = input.nextLine();

        CONTROLLER.editarFilme(idFilme, nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
    }

    public void excluir(Scanner input) {
        mensagem.layoutMensagem("               Filmes - Exclusão               ");
        System.out.print(" ID do filme que deseja excluir: ");
        int idFilme = input.nextInt();

        CONTROLLER.excluirFilme(idFilme);
    }

}
