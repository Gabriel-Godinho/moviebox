package dao;

import connection.DataBaseConnection;
import model.WatchList;
import model.WatchListItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WatchListDAO {

    public WatchList getWatchList() {
        WatchList watchList = new WatchList(new ArrayList<>());
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM watchlist";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                WatchListItem watchListItem = new WatchListItem();
                watchListItem.setIdFilme(rs.getLong("id_filme"));
                watchListItem.setDataInsercaoFilme(rs.getString("data_insercao_filme"));
                watchList.getItensWatchList().add(watchListItem);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao mostrar a watchlist!");
        }

        return watchList;
    }

    public void saveWatchListItem(WatchListItem watchListItem) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO watchlist(id_filme, data_insercao_filme) VALUES(?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, watchListItem.getIdFilme());
            preparedStatement.setString(2, watchListItem.getDataInsercaoFilme());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao mostrar a watchlist!");
        }
    }

    public void deleteWatchListItem(long idFilme) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "DELETE FROM watchlist WHERE id_filme = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idFilme);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao mostrar a watchlist!");
        }
    }

}
