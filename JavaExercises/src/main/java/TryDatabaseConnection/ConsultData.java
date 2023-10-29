package TryDatabaseConnection;

import Database.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecoverData {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from department");

            while (resultSet.next()){
                System.out.println(
                                resultSet.getInt("Id") + " | " +
                                resultSet.getString("Name")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
          DB.closeResultSet(resultSet);
          DB.closeStatement(statement);
          DB.closeConnection();
        }
    }
}
