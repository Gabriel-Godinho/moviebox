package controllers;

import dao.DiretorDAO;
import dao.PaisOrigemDAO;
import dao.relatorios.RelatoriosDAO;
import model.Filme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelatoriosController {

    private final RelatoriosDAO relatoriosDAO = new RelatoriosDAO();
    private final DiretorDAO diretorDAO = new DiretorDAO();
    private final PaisOrigemDAO paisDAO = new PaisOrigemDAO();

    public void listarFilmesNaWatchlistPorDiretor(long idDiretor) {
        System.out.println("------------------------------------------------");
        System.out.println("       Filmes por diretor da sua watchlist      ");
        System.out.println("------------------------------------------------");

        for (Filme filme : relatoriosDAO.buscarFilmesNaWatchlistPorDiretor(idDiretor)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + paisDAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void listarFilmesNaWatchlistPorPais(long idPais) {
        System.out.println("------------------------------------------------");
        System.out.println("        Filmes por país da sua watchlist        ");
        System.out.println("------------------------------------------------");

        for (Filme filme : relatoriosDAO.buscarFilmesNaWatchlistPorPais(idPais)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + paisDAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void listarFilmesNaWatchlistPorData(String dataInsercao) {
        LocalDate localDate = LocalDate.parse(dataInsercao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dataFormatada = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("------------------------------------------------");
        System.out.println("        Filmes por data da sua watchlist        ");
        System.out.println("------------------------------------------------");

        for (Filme filme : relatoriosDAO.buscarFilmesNaWatchlistPorData(dataFormatada)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + paisDAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

}
