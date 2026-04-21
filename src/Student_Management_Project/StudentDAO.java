package Student_Management_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(Student s){
        try{
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setDouble(4, s.getMarks());
            ps.setString(5, s.getCourse());
            ps.setString(6, s.getAddress());
            ps.executeUpdate();
            System.out.println("Student added successfully!");

            conn.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void viewStudent(int id){
        try{
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM Student WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int stuId = rs.getInt("Id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                double marks = rs.getDouble("Marks");
                String course = rs.getString("Course");
                String address = rs.getString("Address");

                System.out.println("Student Id : " + stuId);
                System.out.println("Student Name : " + name);
                System.out.println("Student Age : " + age);
                System.out.println("Student Marks : " + marks);
                System.out.println("Student Course : " + course);
                System.out.println("Student Address : " + address);
            }
            conn.close();
            rs.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void updateRecord(double marks, int id){
        try{
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE Student SET Marks = ? WHERE Id = ?  ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, marks);
            ps.setInt(2, id);
            int rowsUpdated = ps.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("Student record updated successfully!");
            }else {
                System.out.println("No student found with the given Id.");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
