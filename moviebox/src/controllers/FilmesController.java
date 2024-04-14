package controllers;

import dao.FilmeDAO;
import model.Filme;

public class FilmesController {

    private final FilmeDAO filmeDAO = new FilmeDAO();

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
        filmeDAO.delete(idFilme);
    }

    public void listarFilmes() {
        filmeDAO.getAll();
    }

    public void editarFilme(int idFilme, String nomeFilme, int duracao, int ano, int idDiretor, int idPais, String sinopse) {
        Filme filme = new Filme(idFilme, nomeFilme, duracao, ano, idDiretor, idPais, sinopse);
        filmeDAO.update(filme);
    }
}
