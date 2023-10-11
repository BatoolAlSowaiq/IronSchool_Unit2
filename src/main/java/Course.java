import java.util.UUID;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;
    private static int courseCounter = 1;


    public Course(String name, double price) {
        this.courseId = generateCourseID();
        this.name = name;
        this.price = price;
        this.money_earned = 0;
        this.teacher = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void updateMoneyEarned() {
        this.money_earned += this.price;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course Id: " + courseId +
                "\nName: " + name +
                "\nPrice: $" + price +
                "\nMoney Earned: $ " + money_earned +
                "\nTeacher: " + teacher +
                "\n------------------------";
    }
    public String generateCourseID(){
        return "CID_"+ (courseCounter++);
    }
}
