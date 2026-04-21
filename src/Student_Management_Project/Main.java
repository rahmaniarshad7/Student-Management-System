package Student_Management_Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("=====Student Management System=====");
            System.out.println("Select Choice : ");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice between 1 - 5 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter Student Id : ");
                int id = sc.nextInt();
                System.out.println("Enter Student Name : ");
                String name = sc.next();
                System.out.println("Enter Student Age : ");
                int age = sc.nextInt();
                System.out.println("Enter Student Marks : ");
                double marks = sc.nextDouble();
                System.out.println("Enter Student Course : ");
                String course = sc.next();
                System.out.println("Enter Student Address : ");
                String address = sc.next();
                Student s = new Student(id, name, age, marks, course, address);
                StudentDAO dao = new StudentDAO();
                dao.addStudent(s);
                //break;
            }
            if (choice == 2) {
                System.out.println("Enter Student Id to view details : ");
                int id = sc.nextInt();
                StudentDAO dao = new StudentDAO();
                dao.viewStudent(id);
                //break;
            }
            if (choice == 3) {
                System.out.println("Update Student functionality is not implemented yet.");
                break;
            }
            if (choice == 4) {
                System.out.println("Delete Student functionality is not implemented yet.");
                break;
            }
            if(choice == 5) {
                System.out.println("Exiting the system. Thank you!");
                break;
            }
        }
        sc.close();
    }
}
