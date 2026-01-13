import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.sql.*;
public class update_data {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/students"; // database ka naam
            String username = "root";
            String password = "Manish@000";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver check
            System.out.println("Driver loaded!");
            Connection conn = DriverManager.getConnection(url, username, password);

            //query
            String q="update table1 set tName=?,tCity=? where tId=?";
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new Name:");
            String name=br.readLine();
            System.out.println("Enter new city name:");
            String city=br.readLine();
            System.out.println("Enter Id:");
            int id=Integer.parseInt(br.readLine());

            PreparedStatement pstmt=conn.prepareStatement(q);
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
            System.out.println("Done");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
