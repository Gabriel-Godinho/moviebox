package controllers;

import dao.DiretorDAO;
import dao.NacionalidadeDAO;
import model.Diretor;

public class DiretoresController {

    private final DiretorDAO diretorDAO = new DiretorDAO();
    private final NacionalidadeDAO nacionalidadeDAO = new NacionalidadeDAO();

    public void cadastrarDiretor(String nomeDiretor, long idNacionalidade) {
        Diretor diretor = new Diretor(nomeDiretor, idNacionalidade);

        diretor.setNomeDiretor(nomeDiretor);
        diretor.setIdNacionalidade(idNacionalidade);

        diretorDAO.save(diretor);
    }

    public void excluirDiretor(int idDiretor) {
        diretorDAO.delete(idDiretor);
    }

    public void listarDiretores() {
        System.out.println("------------------------------------------------");
        System.out.println("                    DIRETORES                   ");
        System.out.println("------------------------------------------------");
        for(Diretor diretor : diretorDAO.getAll()) {
            System.out.println( "Nome: " + diretor.getNomeDiretor());
            System.out.println( "Nacionalidade: " + nacionalidadeDAO.getById(diretor.getIdNacionalidade()).getNomeNacionalidade());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarDiretor(int idDiretor, String nomeDiretor, long idNacionalidade) {
        Diretor diretor = new Diretor(idDiretor, nomeDiretor, idNacionalidade);
        diretorDAO.update(diretor);
    }
}
