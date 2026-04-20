package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatement1 {

    private static final String url = "jdbc:mysql://localhost:3306/StudentRecord";
    private static final  String username = "root";
    private static final String password = "7544";

    static void main() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name of Student : ");
        String name = input.nextLine();

        System.out.print("Enter Age of Student : ");
        int age = input.nextInt();

        System.out.print("Enter Marks of Student : ");
        double marks = input.nextDouble();
        input.nextLine();

        System.out.print("Enter Address of Student : ");
        String address = input.nextLine();

        // Step 1: Load Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!!!");

        } catch (ClassNotFoundException e){
            System.out.println("Driver Not Found");
            System.out.println("Error " + e.getMessage());
        }
        //Step 2: Create Connection
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Student(Name, Age, Marks, Address) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println("Connection Established Successfully!!!");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, marks);
            ps.setString(4, address);

            int rowAffected = ps.executeUpdate();
            if (rowAffected > 0){
                System.out.println("Record Inserted Successfully!!!");
            } else {
                System.out.println("Failed to Insert Record!!!");
            }
            conn.close();
            ps.close();


        } catch (SQLException e){
            System.out.println("Connection Failed!!!");
            System.out.println("Error " + e.getMessage());
        }
    }
}
