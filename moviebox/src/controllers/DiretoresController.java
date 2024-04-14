package controllers;

import dao.DiretorDAO;
import model.Diretor;

public class DiretoresController {

    private final DiretorDAO diretorDAO = new DiretorDAO();

    public void cadastrarDiretor(String nomeDiretor, String nacionalidade) {
        Diretor diretor = new Diretor(nomeDiretor, nacionalidade);

        diretor.setNomeDiretor(nomeDiretor);
        diretor.setNacionalidade(nacionalidade);

        diretorDAO.save(diretor);
    }

    public void excluirDiretor(int idDiretor) {
        diretorDAO.delete(idDiretor);
    }

    public void listarDiretores() {
        diretorDAO.getAll();
    }

    public void editarDiretor(int idDiretor, String nomeDiretor, String nacionalidade) {
        Diretor diretor = new Diretor(idDiretor, nomeDiretor, nacionalidade);
        diretorDAO.update(diretor);
    }
}
