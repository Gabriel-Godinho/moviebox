package dao;

import connection.DataBaseConnection;
import model.PaisOrigem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PaisOrigemDAO {

    public Set<PaisOrigem> getAll() {
        Set<PaisOrigem> paises = new HashSet<>();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM clients";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PaisOrigem paisOrigem = new PaisOrigem();
                paisOrigem.setIdPais(rs.getLong("id_pais"));
                paisOrigem.setNomePais(rs.getString("nome_pais"));
                paises.add(paisOrigem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os países cadastrados!");
        }

        return paises;
    }

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
