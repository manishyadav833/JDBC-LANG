import java.sql.*;
import java.io.*;
public class Insert_Data {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/students"; // database ka naam
            String username = "root";
            String password = "Manish@000";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver check
            System.out.println("Driver loaded!");
            Connection conn = DriverManager.getConnection(url, username, password);
            //Create a Query
            String q="insert into table1(tNAme,tcity) values(?,?)";
            //prepare statement
            PreparedStatement pstmt=conn.prepareStatement(q);

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name:");
            String name=br.readLine();
            System.out.println("ENter CIty:");
            String city=br.readLine();
            //set value
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.executeUpdate();
            System.out.println("Inserted");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
