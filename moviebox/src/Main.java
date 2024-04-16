import controllers.*;
import view.DiretoresView;
import view.FilmesView;
import view.PaisesView;
import view.WatchlistView;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        int escolha;
        Scanner input = new Scanner(System.in);

        do {
            escolha = menu(input);

            switch (escolha) {
                case 1:
                    new FilmesView().cadastro();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 2:
                    new FilmesView().edicao();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 3:
                    new FilmesController().listarFilmes();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 4:
                    new DiretoresView().cadastro();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 5:
                    new DiretoresView().edicao();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 6:
                    new DiretoresController().listarDiretores();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 7:
                    new PaisesView().cadastro();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 8:
                    new PaisesView().edicao();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 9:
                    new PaisesController().listarPaises();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 10:
                    new WatchlistView().inserir();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 11:
                    new WatchlistView().remover();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 12:
                    new WatchlistsController().mostrar();
                    System.out.print("Para voltar ao menu tecle [0]");
                    escolha = input.nextInt();
                    break;
                case 13:
                    System.exit(0);
                    break;
                default:
                    System.out.print("Opção inválida. Escolha outra: ");
                    escolha = input.nextInt();
            }
        } while (escolha >= 0);

        input.close();
    }

    private static int menu(Scanner input) {
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

        return input.nextInt();
    }
    
}