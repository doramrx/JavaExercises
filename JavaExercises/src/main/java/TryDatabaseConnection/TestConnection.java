package TryDatabaseConnection;

import Database.DB;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection connection = DB.getConnection();
        DB.closeConnection();
    }
}
