package controllers;

import dao.entities.PaisOrigemDAO;
import model.PaisOrigem;
import view.MensagensView;

public class PaisController {

    private final PaisOrigemDAO PAIS_DAO = new PaisOrigemDAO();
    private final MensagensView MENSAGEM_VIEW = new MensagensView();

    public void cadastrarPais(String nomePais) {
        PaisOrigem pais = new PaisOrigem(nomePais);

        pais.setNomePais(nomePais);

        PAIS_DAO.save(pais);
    }

    public void listarPaises() {
        MENSAGEM_VIEW.layoutMensagem("                    PAÍSES                     ");

        for (PaisOrigem pais : PAIS_DAO.getAll()) {
            System.out.println(" ID: " + pais.getIdPais());
            System.out.println(" Nome: " + pais.getNomePais());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarPais(int idPais, String nomePais) {
        PaisOrigem pais = new PaisOrigem(idPais, nomePais);

        PAIS_DAO.update(pais);
    }

}
