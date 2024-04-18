package dao.entities;

import connection.DataBaseConnection;
import model.WatchList;
import model.WatchListItem;
import view.MensagensView;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class WatchListDAO {

    private final MensagensView mensagem = new MensagensView();

    public final WatchList getWatchList() {
        WatchList watchList = new WatchList(new ArrayList<>());

        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM watchlist";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                WatchListItem watchListItem = new WatchListItem();
                watchListItem.setIdFilme(resultSet.getLong("id_filme"));
                watchListItem.setDataInsercaoFilme(resultSet.getString("data_insercao_filme"));
                watchList.getItensWatchList().add(watchListItem);
            }

        } catch (SQLException e) {
            mensagem.layoutMensagem("Erro ao mostrar a watchlist!");
        }

        return watchList;
    }

    public final void saveWatchListItem(WatchListItem watchListItem) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO watchlist(id_filme, data_insercao_filme) VALUES(?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, watchListItem.getIdFilme());
            preparedStatement.setDate(2, Date.valueOf(watchListItem.getDataInsercaoFilme()));
            preparedStatement.executeUpdate();

            mensagem.layoutMensagem("Filme adicionado na watchlist com sucesso!");
        } catch (SQLException e) {
            mensagem.layoutMensagem("Erro ao adicionar filme na watchlist!");
        }
    }

    public final void deleteWatchListItem(long idFilme) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "DELETE FROM watchlist WHERE id_filme = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idFilme);
            preparedStatement.executeUpdate();

            mensagem.layoutMensagem("Filme removido da watchlist com sucesso!");
        } catch (SQLException e) {
            mensagem.layoutMensagem("Erro ao remover o filme da watchlist!");
        }
    }

}
