import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;
    private static int teacherCounter = 1;

    public Teacher(String name, double salary) {
        this.teacherId = generateTeacherID();
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }
    @Override
    public String toString() {
        return "\nTeacher Id: " + teacherId +
                "\nName: " + name +
                "\nSalary: $" + salary +
                "\n------------------------";
    }
    public String generateTeacherID(){
        return "TID_"+(teacherCounter++);
    }

}
