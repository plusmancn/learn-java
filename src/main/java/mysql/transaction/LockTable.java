package mysql.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * mysql.transaction
 *
 * @author plusman
 * @since 2020/9/27
 */
public class LockTable {
    public static void main(String[] args) throws InterruptedException {


        new Thread(() -> {
            Statement stmt = null;
            try (Connection c1 = Database.getConnection()){
                System.out.println("lock tables ");
                stmt = c1.createStatement();
                stmt.execute("LOCK TABLES wallet READ, WRITE");

                stmt.executeQuery("SELECT * FROM user");

                Thread.sleep(10000);

                System.out.println("unlock tables");
                stmt.execute("UNLOCK TABLES");
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(10);

        new Thread(() -> {
            Statement stmt = null;
            try (Connection c2 = Database.getConnection()) {
                System.out.println("query tables");
                stmt = c2.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM wallet");
                while(rs.next()) {
                    System.out.println(String.format("%s own $%s",
                        rs.getString("customer_id"),
                        rs.getString("balance")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
