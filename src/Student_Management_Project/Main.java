package Student_Management_Project;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.println("=====Student Management System=====");
        System.out.println("Select Choice : ");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");

        int choice = sc.nextInt();
        System.out.println("You Selected : " + choice);
    }
}
