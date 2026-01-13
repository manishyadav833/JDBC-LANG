import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/students"; // database ka naam
        String username = "root";
        String password = "Manish@000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver check
            System.out.println("Driver loaded!");

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}