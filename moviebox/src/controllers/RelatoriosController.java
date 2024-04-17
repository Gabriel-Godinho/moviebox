package controllers;

import dao.DiretorDAO;
import dao.PaisOrigemDAO;
import dao.relatorios.RelatoriosDAO;
import model.Filme;
import view.MensagensView;

public class RelatoriosController {

    private final RelatoriosDAO relatoriosDAO = new RelatoriosDAO();
    private final DiretorDAO diretorDAO = new DiretorDAO();
    private final PaisOrigemDAO paisDAO = new PaisOrigemDAO();
    private final MensagensView mensagem = new MensagensView();

    public void listarFilmesNaWatchlistPorDiretor(long idDiretor) {
        mensagem.limparTela(6);
        mensagem.layoutMensagem("Filmes por " + diretorDAO.getById(idDiretor).getNomeDiretor() + " na watchlist");

        for (Filme filme : relatoriosDAO.buscarFilmesNaWatchlistPorDiretor(idDiretor)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
//            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + paisDAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void listarFilmesNaWatchlistPorPais(long idPais) {
        mensagem.limparTela(6);
        mensagem.layoutMensagem(paisDAO.getById(idPais).getNomePais() + " na sua watchlist");

        for (Filme filme : relatoriosDAO.buscarFilmesNaWatchlistPorPais(idPais)) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void listarFilmesNaWatchlistPorData(int anoInsercao) {
//        LocalDate localDate = LocalDate.parse(dataInsercao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        String dataFormatada = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        mensagem.limparTela(6);
        mensagem.layoutMensagem("Filmes adicionados na sua watchlist em " + anoInsercao);

        for (Filme filme : relatoriosDAO.buscarFilmesNaWatchlistPorAnoInserido(anoInsercao)) {
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
