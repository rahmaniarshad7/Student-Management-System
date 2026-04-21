package Student_Management_Project;

public class Student {
    private final int id;
    private final String name;
    private final int age;
    private final double marks;
    private final String course;
    private final String address;

    public Student(int id, String name, int age, double marks, String course, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.course = course;
        this.address = address;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }

    public double getMarks(){
        return marks;
    }

    public String getCourse() {
        return course;
    }

    public String getAddress() {
        return address;
    }
}
