package controllers;

import dao.WatchListDAO;
import model.WatchListItem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WatchlistsController {
    private final WatchListDAO watchlistDAO = new WatchListDAO();

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
        watchlistDAO.getWatchList();
    }
}
