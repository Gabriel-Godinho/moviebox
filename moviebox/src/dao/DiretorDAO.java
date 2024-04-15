package dao;

import connection.DataBaseConnection;
import model.Diretor;
import model.PaisOrigem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DiretorDAO {

    public Set<Diretor> getAll() {
        Set<Diretor> diretores = new HashSet<>();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM diretores";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Diretor diretor = new Diretor();
                diretor.setIdDiretor(rs.getLong("id_diretor"));
                diretor.setNomeDiretor(rs.getString("nome_diretor"));
                diretores.add(diretor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os países cadastrados!");
        }

        return diretores;
    }

    public Diretor getById(long idDiretor) {
        Diretor diretor = new Diretor();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM diretores WHERE id_diretor = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                diretor.setIdDiretor(rs.getLong("id_diretor"));
                diretor.setNomeDiretor(rs.getString("nome_diretor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os diretores cadastrados!");
        }

        return diretor;
    }

    public void save(Diretor diretor) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO diretores(nome_diretor) VALUE(?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, diretor.getNomeDiretor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo diretor!");
        }
    }

    public void update(Diretor diretor) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            if (!diretor.getNomeDiretor().isBlank()) {
                String sql = "UPDATE diretores SET nome_diretor = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, diretor.getNomeDiretor());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o diretor!");
        }
    }

    public final void delete(long idDiretor) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "DELETE FROM diretores WHERE id_diretor = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idDiretor);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o diretor!");
        }
    }

}
