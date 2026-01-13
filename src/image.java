import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.io.*;
public class image {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/students"; // database ka naam
            String username = "root";
            String password = "Manish@000";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver check
            System.out.println("Driver loaded!");
            Connection conn = DriverManager.getConnection(url, username, password);

            //Query
            String q="insert into images(pic) values(?)";
            FileInputStream fis=new FileInputStream("C:\\Users\\Faith\\OneDrive\\Pictures\\Saved Pictures\\myimage.jpeg");
            PreparedStatement pstmt=conn.prepareStatement(q);
            pstmt.setBinaryStream(1,fis);
            pstmt.executeUpdate();
            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
