package view;

import controllers.WatchlistsController;
import java.util.Scanner;

public class WatchlistView {

    private final WatchlistsController CONTROLLER = new WatchlistsController();
    private final MensagensView mensagem = new MensagensView();

    public void escolherAcao(Scanner input) {
        int escolha;
        System.out.println("----------------------------------------------------");
        mensagem.layoutMensagem("               Editar Watchlist                ");
        System.out.println(" Para ADICIONAR um filme digite [1] ");
        System.out.println(" Para REMOVER um filme digite [2] ");
        System.out.println("------------------------------------------------");
        System.out.print("Sua escolha: ");
        escolha = input.nextInt();

        if(escolha == 1) adicionar(input);
        else remover(input);
    }

    public void adicionar(Scanner input) {

        mensagem.layoutMensagem("            Watchlist - Adicionar              ");
        System.out.print(" ID do filme que deseja adicionar: ");
        int idFilme = input.nextInt();

        System.out.println("----------------------------------------------");

        CONTROLLER.inserirFilme(idFilme);
    }

    public void remover(Scanner input) {

        mensagem.layoutMensagem("             Watchlist - Remover               ");
        System.out.print(" ID do filme que deseja remover: ");
        int idFilme = input.nextInt();

        System.out.println("----------------------------------------------");

        CONTROLLER.removerFilme(idFilme);
    }

}
