package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {

    private static final String url = "jdbc:mysql://localhost:3306/StudentRecord";
    private static final  String username = "root";
    private static final String password = "7544";

    public static void main(String[] args){

//   Step 1 --> Load theJDBC Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!!!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
            System.out.println("Error: " + e.getMessage());
        }

        // Step 2 --> Established Connection
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection Established Successfully !!!!");

            String query = "insert into Student (ID, Name, Age, Marks, Address) values (3, 'Alisa Fatma', 12, 85.5, 'Araria')";
            int rowAffected = stmt.executeUpdate(query);
            if(rowAffected > 0){
                System.out.println("Record Inserted Successfully!!!");
            }else {
                System.out.println("Failed to Insert Record!!!");
            }
        }
        catch (SQLException e){
            System.out.println("Connection Failed !!!");
            System.out.println("Error " + e.getMessage());

        }

    }
}
