package Exercise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class C101 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/learn-java";
            Connection connection = DriverManager.getConnection(url, "root", "");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jdbc ORDER BY id DESC ");

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }

            // stmt.executeUpdate("INSERT INTO jdbc (`name`) VALUES ('舒蕾')");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
