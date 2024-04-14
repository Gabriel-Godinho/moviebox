import connection.DataBaseConnection;
import controllers.*;
import model.Filme;
import view.CadastrarFilme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        int escolha = 0;

        do{
            escolha = menu();
            try {
                switch (escolha) {
                    case 1:
                        new CadastrarFilme().cadastro();
                        break;
                    case 2:
                        new FilmesController().listarFilmes(connection);
                        break;
                    case 3:
                        new DiretoresController().listarDiretores(connection);
                        break;
                    case 4:
                        new PaisesController().listarPaises(connection);
                        break;
                    case 5:
                        new ListasController().verListas(connection);
                        break;
                    case 6:
                        new WatchlistsController().verWatchlist(connection);
                        break;
                    case 7:
                        System.exit(0);
                }
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } while(escolha > 0 && escolha < 8);

    }

    private static int menu() {
        System.out.println("-----------------------------------");
        System.out.println("             Filmoteca            ");
        System.out.println("-----------------------------------");
        System.out.println(" 1. Cadastrar filme");
        System.out.println(" 2. Listar filmes");
        System.out.println(" 3. Listar diretores");
        System.out.println(" 4. Listar países");
        System.out.println(" 5. Ver listas");
        System.out.println(" 6. Ver watchlist");
        System.out.println(" 7. Sair");
        System.out.println("-----------------------------------");
        System.out.print(" Escolha uma opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}