package controllers;

import dao.DiretorDAO;
import dao.NacionalidadeDAO;
import model.Diretor;
import view.MensagensView;

public class DiretoresController {

    private final DiretorDAO diretorDAO = new DiretorDAO();
    private final NacionalidadeDAO nacionalidadeDAO = new NacionalidadeDAO();
    private final MensagensView mensagem = new MensagensView();

    public void cadastrarDiretor(String nomeDiretor, long idNacionalidade) {
        Diretor diretor = new Diretor(nomeDiretor, idNacionalidade);

        diretor.setNomeDiretor(nomeDiretor);
        diretor.setIdNacionalidade(idNacionalidade);

        diretorDAO.save(diretor);
    }

    public void listarDiretores() {
        mensagem.layoutMensagem("                   DIRETORES                   ");
        for(Diretor diretor : diretorDAO.getAll()) {
            System.out.println(" ID: " + diretor.getIdDiretor());
            System.out.println(" Nome: " + diretor.getNomeDiretor());
            System.out.println(" Nacionalidade: " + nacionalidadeDAO.getById(diretor.getIdNacionalidade()).getNomeNacionalidade());
            System.out.println("------------------------------------------------");
        }
    }

    public void editarDiretor(int idDiretor, String nomeDiretor, long idNacionalidade) {
        Diretor diretor = new Diretor(idDiretor, nomeDiretor, idNacionalidade);
        diretorDAO.update(diretor);
    }
}
