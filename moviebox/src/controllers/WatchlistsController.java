package controllers;

import dao.FilmeDAO;
import dao.WatchListDAO;
import model.WatchListItem;
import view.MensagensView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WatchlistsController {
    private final WatchListDAO watchlistDAO = new WatchListDAO();
    private final FilmeDAO filmeDAO = new FilmeDAO();
    private final MensagensView mensagem = new MensagensView();

    public void inserirFilme(int idFilme) {
        LocalDate localDate = LocalDate.now();

        String dataFormatada = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(idFilme);

        System.out.println(dataFormatada);

        WatchListItem watchlistItem = new WatchListItem(idFilme, dataFormatada);

        watchlistDAO.saveWatchListItem(watchlistItem);
    }

    public void removerFilme(int idFilme) {
        watchlistDAO.deleteWatchListItem(idFilme);
    }

    public void mostrar() {
        mensagem.layoutMensagem("                   WATCHLIST                   ");
        for(WatchListItem watchlistItem : watchlistDAO.getWatchList().getItensWatchList()) {
            SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
            Date dataBanco;
            try {
                dataBanco = sdfBanco.parse(watchlistItem.getDataInsercaoFilme());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(dataBanco);

            System.out.println( "Filme: " + filmeDAO.getById(watchlistItem.getIdFilme()).getNomeFilme() );
            System.out.println( "Adicionado em: " + data);
            System.out.println("------------------------------------------------");
        }
    }
}
