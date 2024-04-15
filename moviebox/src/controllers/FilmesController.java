package controllers;

import dao.DiretorDAO;
import dao.FilmeDAO;
import dao.PaisOrigemDAO;
import dao.WatchListDAO;
import model.Filme;

public class FilmesController {

    private final FilmeDAO filmeDAO = new FilmeDAO();
    private final WatchListDAO watchlistDAO = new WatchListDAO();
    private final PaisOrigemDAO paisDAO = new PaisOrigemDAO();
    private final DiretorDAO diretorDAO = new DiretorDAO();

    public void cadastrarFilme(String nomeFilme, int duracao, int ano, long idDiretor, long idPais, String sinopse) {
        Filme filme = new Filme(nomeFilme, duracao, ano, idDiretor, idPais, sinopse);

        filme.setNomeFilme(nomeFilme);
        filme.setDuracao(duracao);
        filme.setAno(ano);
        filme.setIdDiretor(idDiretor);
        filme.setIdPais(idPais);
        filme.setSinopse(sinopse);

        filmeDAO.save(filme);
    }

    public void excluirFilme(int idFilme) {
        watchlistDAO.deleteWatchListItem(idFilme);
        filmeDAO.delete(idFilme);
    }

    public void listarFilmes() {
        System.out.println("------------------------------------------------");
        System.out.println("                     FILMES                     ");
        System.out.println("------------------------------------------------");
        for(Filme filme : filmeDAO.getAll()) {
            System.out.println( "Nome: " + filme.getNomeFilme());
            System.out.println( "Diretor: " + diretorDAO.getById(filme.getIdDiretor()).getNomeDiretor());
            System.out.println( "Duração: " + filme.getDuracao() + " minutos");
            System.out.println( "Ano de lançamento: " + filme.getAno());
            System.out.println( "País de origem: " + paisDAO.getById(filme.getIdPais()).getNomePais());
            System.out.println( "Sinopse: " + filme.getSinopse());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarFilme(int idFilme, String nomeFilme, int duracao, int ano, int idDiretor, int idPais, String sinopse) {
        Filme filme = new Filme(idFilme, nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
        filmeDAO.update(filme);
    }
}
