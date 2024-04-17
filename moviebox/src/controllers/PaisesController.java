package controllers;

import dao.PaisOrigemDAO;
import model.PaisOrigem;
import view.MensagensView;

public class PaisesController {
    private final PaisOrigemDAO paisDAO = new PaisOrigemDAO();
    private final MensagensView mensagem = new MensagensView();

    public void cadastrarPais(String nomePais) {
        PaisOrigem pais = new PaisOrigem(nomePais);

        pais.setNomePais(nomePais);

        paisDAO.save(pais);
    }

    public void listarPaises() {
        mensagem.layoutMensagem("                    PAÍSES                     ");
        for(PaisOrigem pais : paisDAO.getAll()) {
            System.out.println(" ID: " + pais.getIdPais());
            System.out.println(" Nome: " + pais.getNomePais());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarPais(int idPais, String nomePais) {
        PaisOrigem pais = new PaisOrigem(idPais, nomePais);
        paisDAO.update(pais);
    }
}
