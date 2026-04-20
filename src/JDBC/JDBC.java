package JDBC;

import java.sql.*;

public class JDBC {

    private static final String url = "jdbc:mysql://localhost:3306/StudentRecord";
    private static final  String username = "root";
    private static final String password = "7544";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
            System.out.println("Error: " + e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");

            Statement statement = connection.createStatement();
            String query = "select * from Student where ID = 1";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                double mark = resultSet.getDouble("Marks");
                String address = resultSet.getString("Address");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Mark: " + mark);
                System.out.println("Address: " + address);
                System.out.println("-----------------------------");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println("Error: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
        }
    }
}
