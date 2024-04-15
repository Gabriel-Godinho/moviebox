package controllers;

import dao.FilmeDAO;
import dao.WatchListDAO;
import model.Diretor;
import model.WatchListItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WatchlistsController {
    private final WatchListDAO watchlistDAO = new WatchListDAO();
    private final FilmeDAO filmeDAO = new FilmeDAO();

    public void inserirFilme(int idFilme) {
        Date data = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        WatchListItem watchlistItem = new WatchListItem(idFilme, sdf.format(data));

        watchlistDAO.saveWatchListItem(watchlistItem);

    }

    public void removerFilme(int idFilme) {
        watchlistDAO.deleteWatchListItem(idFilme);
    }

    public void mostrar() {
        for(WatchListItem watchlistItem : watchlistDAO.getWatchList().getItensWatchList()) {
            SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
            Date dataBanco = null;
            try {
                dataBanco = sdfBanco.parse(watchlistItem.getDataInsercaoFilme());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(dataBanco);

            System.out.println( "Filme: " + filmeDAO.getById(watchlistItem.getIdFilme()).getNomeFilme());
            System.out.println( "Adicionado em: " + data);
            System.out.println("------------------------------------------------");
        }
    }
}
