package controllers;

import dao.DiretorDAO;
import model.Diretor;
import model.Filme;

public class DiretoresController {

    private final DiretorDAO diretorDAO = new DiretorDAO();

    public void cadastrarDiretor(String nomeDiretor, String nacionalidade) {
        Diretor diretor = new Diretor(nomeDiretor, nacionalidade);

        diretor.setNomeDiretor(nomeDiretor);
        diretor.setNacionalidade(nacionalidade);

        diretorDAO.save(diretor);
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
