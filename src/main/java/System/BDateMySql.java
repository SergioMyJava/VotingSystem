package System;
import java.sql.*;

public class BDateMySql {
    private static Connection connection;
    public static final String url = "jdbc:mysql://localhost:3306/MySql?useSSL=false";
    public static final String user = "root";
    public static final String password = "root";

    private static void getConnection(String url, String login, String password) throws SQLException {

        if (connection != null)
            return;
        connection = DriverManager.getConnection(url, login, password);
    }

    private static void createConnect() throws SQLException {

        getConnection(BDateMySql.url, BDateMySql.user, BDateMySql.password);
    }

    public static ResultSet query(String query) throws SQLException {

        createConnect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);

    }

    public static int update(String query) throws SQLException {

        createConnect();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);

    }
    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
