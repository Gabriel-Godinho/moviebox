package controllers;

import dao.DiretorDAO;
import dao.NacionalidadeDAO;
import model.Diretor;
import view.MensagensView;

public class DiretorController {

    private final DiretorDAO DIRETOR_DAO = new DiretorDAO();
    private final NacionalidadeDAO NACIONALIDADE_DAO = new NacionalidadeDAO();
    private final MensagensView MENSAGEM_VIEW = new MensagensView();

    public void cadastrarDiretor(String nomeDiretor, long idNacionalidade) {
        Diretor diretor = new Diretor(nomeDiretor, idNacionalidade);

        diretor.setNomeDiretor(nomeDiretor);
        diretor.setIdNacionalidade(idNacionalidade);

        DIRETOR_DAO.save(diretor);
    }

    public void listarDiretores() {
        MENSAGEM_VIEW.layoutMensagem("                   DIRETORES                   ");

        for (Diretor diretor : DIRETOR_DAO.getAll()) {
            System.out.println(" ID: " + diretor.getIdDiretor());
            System.out.println(" Nome: " + diretor.getNomeDiretor());
            System.out.println(" Nacionalidade: " + NACIONALIDADE_DAO.getById(diretor.getIdNacionalidade()).getNomeNacionalidade());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarDiretor(int idDiretor, String nomeDiretor, long idNacionalidade) {
        Diretor diretor = new Diretor(idDiretor, nomeDiretor, idNacionalidade);

        DIRETOR_DAO.update(diretor);
    }

}
