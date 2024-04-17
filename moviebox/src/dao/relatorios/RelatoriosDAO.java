package dao.relatorios;

import connection.DataBaseConnection;
import model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RelatoriosDAO {

    /**
     * Busca todos os filmes dirigidos por um determinado diretor
     * inseridos na watchlist.
     *
     * @param idDiretor ID do diretor.
     * @return Todos os filmes da watchlist que foram dirigidos pelo diretor escolhido.
     * */
    public final Set<Filme> buscarFilmesNaWatchlistPorDiretor(long idDiretor) {
        Set<Filme> filmes = new HashSet<>();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = """
                    SELECT * FROM filmes AS f INNER JOIN watchlist AS w
                    ON f.id_filme = w.id_filme
                    WHERE f.id_diretor = ?
                    """;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idDiretor);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Filme filme = new Filme();
                filme.setIdDiretor(resultSet.getLong("id_filme"));
                filme.setNomeFilme(resultSet.getString("nome_filme"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setIdDiretor(resultSet.getLong("id_diretor"));
                filme.setIdPais(resultSet.getLong("id_pais"));
                filme.setSinopse(resultSet.getString("sinopse"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os diretores cadastrados!");
        }

        return filmes;
    }

    /**
     * Busca todos os filmes de um determinado país
     * inseridos na watchlist.
     *
     * @param idPais ID do país.
     * @return Todos os filmes da watchlist cuja origem seja o país escolhido.
     * */
    public final Set<Filme> buscarFilmesNaWatchlistPorPais(long idPais) {
        Set<Filme> filmes = new HashSet<>();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = """
                    SELECT * FROM filmes AS f INNER JOIN watchlist AS w
                    ON f.id_filme = w.id_filme
                    WHERE f.id_pais = ?
                    """;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, idPais);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Filme filme = new Filme();
                filme.setIdDiretor(resultSet.getLong("id_filme"));
                filme.setNomeFilme(resultSet.getString("nome_filme"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setIdDiretor(resultSet.getLong("id_diretor"));
                filme.setIdPais(resultSet.getLong("id_pais"));
                filme.setSinopse(resultSet.getString("sinopse"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os diretores cadastrados!");
        }

        return filmes;
    }

    public final Set<Filme> buscarFilmesNaWatchlistPorData(String dataInsercao) {
        Set<Filme> filmes = new HashSet<>();
        try {
            Connection conn = DataBaseConnection.getInstance().getConn();
            String sql = """
                    SELECT * FROM filmes AS f INNER JOIN watchlist AS w
                    ON f.id_filme = w.id_filme
                    WHERE w.data_insercao_filme = ?
                    """;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dataInsercao);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Filme filme = new Filme();
                filme.setIdDiretor(resultSet.getLong("id_filme"));
                filme.setNomeFilme(resultSet.getString("nome_filme"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setIdDiretor(resultSet.getLong("id_diretor"));
                filme.setIdPais(resultSet.getLong("id_pais"));
                filme.setSinopse(resultSet.getString("sinopse"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar os diretores cadastrados!");
        }

        return filmes;
    }
}
