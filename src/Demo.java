import java.sql.*;
public class Demo {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/students?useSSL=false&serverTimezone=UTC"; // database ka naam
            String username = "root";
            String password = "Manish@000";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver check
            System.out.println("Driver loaded!");
            Connection conn = DriverManager.getConnection(url, username, password);
            //create Query
            String q="Create table table1(tId int(20) primary key auto_increment, tName varchar(20) not null, tCity varchar(400))";
            Statement stmt= conn.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table created in database..");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
