package dao;

import connection.DataBaseConnection;
import model.Diretor;
import model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FilmeDAO {

    public Set<Filme> getAll() {
        Set<Filme> filmes = new HashSet<>();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "SELECT * FROM diretores";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getLong("id_filme"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setAno(rs.getInt("ano"));
                filme.setIdDiretor(rs.getLong("id_diretor"));
                filme.setIdPais(rs.getLong("id_pais"));
                filme.setSinopse(rs.getString("sinopse"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os países cadastrados!");
        }

        return filmes;
    }

    public final void save(Filme filme) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "INSERT INTO filmes(nome_filme, duracao, ano, id_diretor, id_pais, sinopse) VALUE(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, filme.getNomeFilme());
            preparedStatement.setInt(2, filme.getDuracao());
            preparedStatement.setInt(3, filme.getDuracao());
            preparedStatement.setLong(4, filme.getIdDiretor());
            preparedStatement.setLong(5, filme.getIdPais());
            preparedStatement.setString(6, filme.getSinopse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo filme!");
        }
    }

    public final void update(Filme filme) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            StringBuilder sb = new StringBuilder("UPDATE filmes SET");

            if (!filme.getNomeFilme().isBlank()) sb.append(" nome_filme = ?");

            if (filme.getDuracao() != 0) {
                if (!sb.toString().endsWith("SET")) sb.append(",");
                sb.append(" duracao = ?");
            }

            if (filme.getDuracao() != 0) {
                if (!sb.toString().endsWith("SET")) sb.append(",");
                sb.append(" ano = ?");
            }

            if (filme.getIdDiretor() != 0) {
                if (!sb.toString().endsWith("SET")) sb.append(",");
                sb.append(" id_diretor = ?");
            }

            if (filme.getIdPais() != 0) {
                if (!sb.toString().endsWith("SET")) sb.append(",");
                sb.append(" id_pais = ?");
            }

            if (!filme.getSinopse().isBlank()) {
                if (!sb.toString().endsWith("SET")) sb.append(",");
                sb.append(" sinopse = ?");
            }

            if (!sb.toString().endsWith("SET")) sb.append(" WHERE id_filme = ?");


            PreparedStatement preparedStatement = conn.prepareStatement(sb.toString());

            if (!filme.getNomeFilme().isBlank()) preparedStatement.setString(1, filme.getNomeFilme());

            if (filme.getDuracao() != 0) preparedStatement.setInt(2, filme.getDuracao());

            if (filme.getDuracao() != 0) preparedStatement.setInt(3, filme.getDuracao());

            if (filme.getIdDiretor() != 0) preparedStatement.setLong(4, filme.getIdDiretor());

            if (filme.getIdPais() != 0) preparedStatement.setLong(5, filme.getIdPais());

            if (!filme.getSinopse().isBlank()) preparedStatement.setString(6, filme.getSinopse());

            if (!sb.toString().endsWith("SET")) {
                preparedStatement.setLong(7, filme.getIdFilme());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo filme!");
        }
    }

    public final void delete(long idFilme) {
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = "DELETE FROM filmes WHERE id_filme = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idFilme);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o novo filme!");
        }
    }

}
