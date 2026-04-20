package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {

    private static final String url = "jdbc:mysql://localhost:3306/StudentRecord";
    private static final  String username = "root";
    private static final String password = "7544";

    static void main() {

        // Step 1: Load JDBC Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!!!");

        } catch (ClassNotFoundException e){
            System.out.println("Driver Not Found");
            System.out.println("Error " + e.getMessage());
        }
        //step 2: Create Connection
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection established Successfully!!!");

            String query = "delete from Student where ID = 3";
            int rowAffected = stmt.executeUpdate(query);
            if (rowAffected > 0){
                System.out.println("Deletion Successfully!!!");
            } else {
                System.out.println("Deletion Failed!!!");
            }

            conn.close();
            stmt.close();

        } catch (SQLException e){
            System.out.println("Connection Failed!!!");
            System.out.println("Error " + e.getMessage());
        }

    }
}
