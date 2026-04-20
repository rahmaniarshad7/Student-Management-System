package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {

    private static final String url = "jdbc:mysql://localhost:3306/StudentRecord";
    private static final  String username = "root";
    private static final String password = "7544";

    static void main() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!!!");
        } catch (ClassNotFoundException e){
            System.out.println("Driver Not Found!!!");
            System.out.println(e.getMessage());
        }
        // Step 2: Create Connection
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection established Successfully!!!");

            String query = "update Student set Marks = 90.5 where ID = 2";
            int rowAffected = stmt.executeUpdate(query);

            if (rowAffected > 0 ){
                System.out.println("Record Updated Successfully!!!");
            }else {
                System.out.println("Failed to Update Record!!!");
            }

            conn.close();
            stmt.close();

        } catch (SQLException e){
            System.out.println("Connection Failed!!!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
