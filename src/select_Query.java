import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.sql.*;
public class select_Query {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/students"; // database ka naam
            String username = "root";
            String password = "Manish@000";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver check
            System.out.println("Driver loaded!");
            Connection conn = DriverManager.getConnection(url, username, password);

            //query
            String query="select * from table1";
            Statement stmt=conn.createStatement();
            ResultSet set=stmt.executeQuery(query);
            while (set.next()){
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);
                System.out.println(name +" " +id +" "+city);
            }
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
