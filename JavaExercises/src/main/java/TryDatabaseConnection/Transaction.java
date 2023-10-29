package TryDatabaseConnection;

import Database.DB;
import Database.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DB.getConnection();

            connection.setAutoCommit(false);

            statement = connection.createStatement();

            int rows1 = statement.executeUpdate(
                    "update seller "
                    + "set BaseSalary = 2090.0 "
                    + "where DepartmentId = 1");

            /*
            int x = 1;
            if(x < 2){
                throw new SQLException("Fake error");
            }
            */

            int rows2 = statement.executeUpdate(
                    "update seller "
                    + "set BaseSalary = 3090.0 "
                    + "where DepartmentId = 2");

            connection.commit();

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);

        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Caused by: " + ex.getMessage());
            }
        } finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
