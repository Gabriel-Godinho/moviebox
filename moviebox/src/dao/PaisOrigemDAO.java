package dao;

import connection.DataBaseConnection;
import model.Diretor;
import model.PaisOrigem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaisOrigemDAO {

    public void save(PaisOrigem paisOrigem) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO paises_origem(nome_pais) VALUE(?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, paisOrigem.getNomePais());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo país de origem!");
        }
    }

    public void update(PaisOrigem paisOrigem) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "UPDATE paises_origem SET nome_pais = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, paisOrigem.getNomePais());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao editar o país de origem!");
        }
    }

    public final void delete(long idPais) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "DELETE FROM paises_origem WHERE id_pais = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idPais);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir país de origem!");
        }
    }

}
