package controllers;

import dao.PaisOrigemDAO;
import model.PaisOrigem;

public class PaisesController {
    private final PaisOrigemDAO paisDAO = new PaisOrigemDAO();

    public void cadastrarPais(String nomePais) {
        PaisOrigem pais = new PaisOrigem(nomePais);

        pais.setNomePais(nomePais);

        paisDAO.save(pais);
    }

    public void excluirPais(int idPais) {
        paisDAO.delete(idPais);
    }

    public void listarPaises() {
        System.out.println("------------------------------------------------");
        System.out.println("                     PAÍSES                     ");
        System.out.println("------------------------------------------------");
        for(PaisOrigem pais : paisDAO.getAll()) {
            System.out.println( "Nome: " + pais.getNomePais());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarPais(int idPais, String nomePais) {
        PaisOrigem pais = new PaisOrigem(idPais, nomePais);
        paisDAO.update(pais);
    }
}
