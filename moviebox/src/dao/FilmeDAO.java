package dao;

import connection.DataBaseConnection;
import model.Filme;

import java.sql.Connection;
import java.sql.SQLException;

public class FilmeDAO {

    public final boolean save(Filme filme) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "";
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo filme!");
        }
    }


}
