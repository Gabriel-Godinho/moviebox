package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private final Connection CONN;
    private static DataBaseConnection instance;

    private DataBaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao conectar no banco de dados!");
            System.exit(1);
        }

        String dbName = "colecao_filmes";
        String hostname = "bancodados2.cf6gg8ueyt35.sa-east-1.rds.amazonaws.com";
        String port = "5432";
        String userName = "postgres";
        String password = "moviebox235689";
        String jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s", hostname, port, dbName);
        this.CONN = DriverManager.getConnection(jdbcUrl, userName, password);
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if(instance == null) instance = new DataBaseConnection();

        return instance;
    }

    public Connection getConn() {
        return this.CONN;
    }

}
