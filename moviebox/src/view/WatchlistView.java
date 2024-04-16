package view;

import controllers.WatchlistsController;

import java.util.Scanner;

public class WatchlistView {

    private final WatchlistsController CONTROLLER = new WatchlistsController();

    public void inserir() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("               Watchlist - Inserir              ");
        System.out.println("------------------------------------------------");
        System.out.print("ID do filme que deseja inserir: ");
        int idFilme = input.nextInt();

        System.out.println("----------------------------------------------");

        CONTROLLER.inserirFilme(idFilme);

        input.close();
    }

    public void remover() {
        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("                 Filmes - Edição                ");
        System.out.println("------------------------------------------------");
        System.out.print("ID do filme que deseja remover: ");
        int idFilme = input.nextInt();

        System.out.println("------------------------------------------------");

        CONTROLLER.removerFilme(idFilme);

        input.close();
    }

}
