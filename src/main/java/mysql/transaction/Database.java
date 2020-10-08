package mysql.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * mysql.transaction
 *
 * @author plusman
 * @since 2020/9/27
 */
public class Database {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/learn_mysql";
            Connection connection = DriverManager.getConnection(url, "root", "");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
