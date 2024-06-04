package ojdbcExample;
import java.sql.*;

public class DatabaseConfig {
    static Connection con;
    static PreparedStatement pstmt;
    static ResultSet rs;

    public static void main(String args[]) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?useSSL=false", "root", "admin");
            
            // Prepare the SQL query
            pstmt = con.prepareStatement("select * from employee where empId = ?");
            
            // Set the parameter
            pstmt.setString(1, "100");
            
            // Execute the query
            rs = pstmt.executeQuery();
            
            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("empName"));
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Print the stack trace for debugging purposes
        } finally {
            // Clean up resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Print the stack trace for debugging purposes
            }
        }
    }
}
