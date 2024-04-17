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

    public final Set<PaisOrigem> getAll() {
        Set<PaisOrigem> paises = new HashSet<>();

        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM paises";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PaisOrigem paisOrigem = new PaisOrigem();
                paisOrigem.setIdPais(resultSet.getLong("id_pais"));
                paisOrigem.setNomePais(resultSet.getString("nome_pais"));
                paises.add(paisOrigem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os países cadastrados!");
        }

        return paises;
    }

    public final PaisOrigem getById(long idPais) {
        PaisOrigem paisOrigem = new PaisOrigem();

        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM paises WHERE id_pais = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idPais);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                paisOrigem.setIdPais(resultSet.getLong("id_pais"));
                paisOrigem.setNomePais(resultSet.getString("nome_pais"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o país especificado!");
        }

        return paisOrigem;
    }

    public final void save(PaisOrigem paisOrigem) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO paises(nome_pais) VALUES(?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, paisOrigem.getNomePais());
            preparedStatement.executeUpdate();

            System.out.println("País cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o novo país!");
        }
    }

    public final void update(PaisOrigem paisOrigem) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();

            if (!paisOrigem.getNomePais().isBlank()) {
                String sql = "UPDATE paises SET nome_pais = ? WHERE id_pais = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, paisOrigem.getNomePais());
                preparedStatement.setLong(2, paisOrigem.getIdPais());
                preparedStatement.executeUpdate();

                System.out.println("País atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o país de origem!");
        }
    }

    public final void delete(long idPais) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "DELETE FROM paises WHERE id_pais = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idPais);
            preparedStatement.executeUpdate();

            System.out.println("País excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir país de origem!");
        }
    }

}
