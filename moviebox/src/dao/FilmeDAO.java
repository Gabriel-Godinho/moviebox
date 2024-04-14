package dao;

import connection.DataBaseConnection;
import model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmeDAO {

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
            String sql = "UPDATE filmes SET nome_filme = ?, duracao = ?, ano = ?, id_diretor = ?, id_pais = ?, sinopse = ? WHERE id_filme = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, filme.getNomeFilme());
            preparedStatement.setInt(2, filme.getDuracao());
            preparedStatement.setInt(3, filme.getDuracao());
            preparedStatement.setLong(4, filme.getIdDiretor());
            preparedStatement.setLong(5, filme.getIdPais());
            preparedStatement.setString(6, filme.getSinopse());
            preparedStatement.setLong(7, filme.getIdFilme());
            preparedStatement.executeUpdate();
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
