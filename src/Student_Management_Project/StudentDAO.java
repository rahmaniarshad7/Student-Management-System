package Student_Management_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
