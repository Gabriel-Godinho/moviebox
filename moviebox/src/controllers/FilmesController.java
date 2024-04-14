package controllers;

import dao.FilmeDAO;
import model.Filme;

public class FilmesController {

    private final FilmeDAO filmeDAO = new FilmeDAO();

    public void cadastrarFilme(String nomeFilme) {
        Filme filme = new Filme();
        filme.setNomeFilme(nomeFilme);
        // Sets...

        filmeDAO.save(filme);
    }

}
