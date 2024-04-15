package dao;

import connection.DataBaseConnection;
import model.Diretor;
import model.PaisOrigem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
                diretor.setNacionalidade(rs.getString("nacionalidade"));
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
            ps.setLong(1, idDiretor);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                diretor.setIdDiretor(rs.getLong("id_diretor"));
                diretor.setNomeDiretor(rs.getString("nome_diretor"));
                diretor.setNacionalidade(rs.getString("nacionalidade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os diretores cadastrados!");
        }

        return diretor;
    }

    public void save(Diretor diretor) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO diretores(nome_diretor, nacionalidade) VALUES(?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, diretor.getNomeDiretor());
            preparedStatement.setString(2, diretor.getNacionalidade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo diretor!");
        }
    }

    public void update(Diretor diretor) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            StringBuilder sb = new StringBuilder("UPDATE diretores SET");

            List<Object> params = new ArrayList<>(); // List to store parameters

            // Check for non-empty values and non-zero numeric values
            if (!diretor.getNomeDiretor().isEmpty()) {
                sb.append(" nome_diretor = ?,");
                params.add(diretor.getNomeDiretor());
            }

            if (!diretor.getNacionalidade().isEmpty()) {
                sb.append(" nacionalidade = ?,");
                params.add(diretor.getNacionalidade());
            }

            // Remove the trailing comma if no fields were updated
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(" WHERE id_diretor = ?");
            params.add(diretor.getIdDiretor());

            PreparedStatement preparedStatement = conn.prepareStatement(sb.toString());

            // Set parameters based on the list
            for (int i = 0; i < params.size(); i++) {
                Object value = params.get(i);
                if (value instanceof String) {
                    preparedStatement.setString(i + 1, (String) value);
                } else {
                    // Handle other data types if needed
                }
            }

            preparedStatement.executeUpdate();

            System.out.println("Diretor atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o diretor!");
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
