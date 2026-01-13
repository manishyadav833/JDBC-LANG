import java.sql.*;
import java.io.*;
public class fetchimage {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String user = "root";
        String pass = "Manish@000";

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Query
            String sql = "SELECT pic FROM images WHERE id = 1";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Get image as stream
                InputStream is = rs.getBinaryStream("pic");

                // Save image
                FileOutputStream fos =
                        new FileOutputStream("C:\\Users\\Faith\\OneDrive\\Desktop\\pic.jpg");

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                fos.close();
                is.close();

                System.out.println("Image fetched & saved successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
