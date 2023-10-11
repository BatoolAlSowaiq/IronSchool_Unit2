import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;
    private static int studentCounter = 1;

    public Student(String name, String address, String email) {
        this.studentId = generateStudentID();
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }
    @Override
    public String toString() {
        return "Student Id: " + studentId +
                "\nName: " + name +
                "\nAddress: " + address +
                "\nEmail:  " + email +
                "\nCourse: " + course +
                "\n------------------------";
    }
    public String generateStudentID(){
        return "SID_"+ (studentCounter++);
    }
}
