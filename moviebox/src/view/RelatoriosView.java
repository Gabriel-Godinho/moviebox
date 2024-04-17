package view;

import controllers.RelatoriosController;

import java.util.Scanner;

public class RelatoriosView {

    private final RelatoriosController CONTROLLER = new RelatoriosController();

    public void relatorioFilmesNaWatchlistPorDiretor(Scanner input) {
        System.out.println("------------------------------------------------");
        System.out.println("     Buscar filmes da watchlist por diretor     ");
        System.out.println("------------------------------------------------");
        System.out.print("Diretor: ");
        long idDiretor = input.nextLong();

        CONTROLLER.listarFilmesNaWatchlistPorDiretor(idDiretor);
    }

    public void relatorioFilmesNaWatchlistPorPais(Scanner input) {
        System.out.println("------------------------------------------------");
        System.out.println("       Buscar filmes da watchlist por pais      ");
        System.out.println("------------------------------------------------");
        System.out.print("País: ");
        long idPais = input.nextLong();

        CONTROLLER.listarFilmesNaWatchlistPorPais(idPais);
    }

    public void relatorioFilmesNaWatchlistPorData(Scanner input) {
        System.out.println("------------------------------------------------");
        System.out.println("       Buscar filmes da watchlist por data      ");
        System.out.println("------------------------------------------------");
        System.out.print("Data (dd/MM/yyyy): ");
        String dataInsercao = input.nextLine();

        CONTROLLER.listarFilmesNaWatchlistPorData(dataInsercao);
    }

    public void mostrarLista() {

    }

}
