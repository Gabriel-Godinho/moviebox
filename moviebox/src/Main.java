import controllers.*;
import model.WatchList;
import view.DiretoresView;
import view.FilmesView;
import view.PaisesView;
import view.WatchlistView;

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
                        new FilmesView().cadastro();
                        break;
                    case 2:
                        new FilmesView().edicao();
                        break;
                    case 3:
                        new FilmesController().listarFilmes();
                        break;
                    case 4:
                        new DiretoresView().cadastro();
                        break;
                    case 5:
                        new DiretoresView().edicao();
                        break;
                    case 6:
                        new DiretoresController().listarDiretores();
                        break;
                    case 7:
                        new PaisesView().cadastro();
                        break;
                    case 8:
                        new PaisesView().edicao();
                        break;
                    case 9:
                        new PaisesController().listarPaises();
                        break;
                    case 10:
                        new WatchlistView().inserir();
                        break;
                    case 11:
                        new WatchlistView().remover();
                        break;
                    case 12:
                        new WatchlistsController().mostrar();
                        break;
                    case 13:
                        System.exit(0);
                }
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } while(escolha > 0 && escolha < 14);
    }

    private static int menu() {
        System.out.println("-----------------------------------");
        System.out.println("              Filmoteca            ");
        System.out.println("-----------------------------------");
        System.out.println(" 1. Cadastrar filme");
        System.out.println(" 2. Editar/Excluir filme");
        System.out.println(" 3. Listar filmes");
        System.out.println(" 4. Cadastrar diretor");
        System.out.println(" 5. Editar/Excluir diretor");
        System.out.println(" 6. Listar diretores");
        System.out.println(" 7. Cadastrar país");
        System.out.println(" 8. Editar/Excluir país");
        System.out.println(" 9. Listar países");
        System.out.println(" 10. Inserir filme na watchlist");
        System.out.println(" 11. Remover filme da watchlist");
        System.out.println(" 12. Ver watchlist");
        System.out.println(" 13. Sair");
        System.out.println("-----------------------------------");
        System.out.print(" Escolha uma opção: ");
            Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}