package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private final String DB_NAME = "colecao_filmes";
    private final String HOSTNAME = "bancodados2.cf6gg8ueyt35.sa-east-1.rds.amazonaws.com";
    private final String PORT = "5432";
    private final String USER_NAME = "postgres";
    private final String PASSWORD = "moviebox235689";
    private final Connection CONN;
    private static DataBaseConnection instance;

    private DataBaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ocorreu um erro ao tentar estabelecer a conexão com o banco de dados!");
            System.exit(1);
        }

        final String CONNECTION_URL = String.format("jdbc:postgresql://%s:%s/%s", HOSTNAME, PORT, DB_NAME);
        this.CONN = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) instance = new DataBaseConnection();

        return instance;
    }

    public Connection getConn() {
        return this.CONN;
    }

}
