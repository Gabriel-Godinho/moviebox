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

    public void excluirDiretor(int idDiretor) {
        diretorDAO.delete(idDiretor);
    }

    public void listarDiretores() {
        for(Diretor diretor : diretorDAO.getAll()) {
            System.out.println( "Nome: " + diretor.getNomeDiretor());
            System.out.println( "Nacionalidade: " + diretor.getNacionalidade());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarDiretor(int idDiretor, String nomeDiretor, String nacionalidade) {
        Diretor diretor = new Diretor(idDiretor, nomeDiretor, nacionalidade);
        diretorDAO.update(diretor);
    }
}
