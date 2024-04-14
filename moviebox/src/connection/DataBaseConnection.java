package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private final Connection CONN;
    private static DataBaseConnection instance;

    private DataBaseConnection() throws SQLException {
        final String connectionString = "bancodados2.cf6gg8ueyt35.sa-east-1.rds.amazonaws.com";
        final String user = "postgres";
        final String pass = "moviebox235689";
        this.CONN = DriverManager.getConnection(connectionString, user, pass);
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if(instance == null) instance = new DataBaseConnection();

        return instance;
    }

    public Connection getConn() {
        return this.CONN;
    }

}
