package controllers;

import dao.entities.DiretorDAO;
import dao.entities.PaisOrigemDAO;
import dao.relatorios.RelatoriosDAO;
import model.Filme;
import view.MensagensView;

public class RelatoriosController {

    private final RelatoriosDAO RELATORIOS_DAO = new RelatoriosDAO();
    private final DiretorDAO DIRETOR_DAO = new DiretorDAO();
    private final PaisOrigemDAO PAIS_DAO = new PaisOrigemDAO();
    private final MensagensView MENSAGEM_VIEW = new MensagensView();

    public void listarFilmesNaWatchlistPorDiretor(long idDiretor) {
        MENSAGEM_VIEW.limparTela(6);
        MENSAGEM_VIEW.layoutMensagem("Filmes por " + DIRETOR_DAO.getById(idDiretor).getNomeDiretor() + " na watchlist");

        for (Filme filme : RELATORIOS_DAO.buscarFilmesNaWatchlistPorDiretor(idDiretor)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
//            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + PAIS_DAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void listarFilmesNaWatchlistPorPais(long idPais) {
        MENSAGEM_VIEW.limparTela(6);
        MENSAGEM_VIEW.layoutMensagem(PAIS_DAO.getById(idPais).getNomePais() + " na sua watchlist");

        for (Filme filme : RELATORIOS_DAO.buscarFilmesNaWatchlistPorPais(idPais)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + DIRETOR_DAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void listarFilmesNaWatchlistPorData(int anoInsercao) {
//        LocalDate localDate = LocalDate.parse(dataInsercao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        String dataFormatada = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        MENSAGEM_VIEW.limparTela(6);
        MENSAGEM_VIEW.layoutMensagem("Filmes adicionados na sua watchlist em " + anoInsercao);

        for (Filme filme : RELATORIOS_DAO.buscarFilmesNaWatchlistPorAnoInserido(anoInsercao)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + DIRETOR_DAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + PAIS_DAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

}
