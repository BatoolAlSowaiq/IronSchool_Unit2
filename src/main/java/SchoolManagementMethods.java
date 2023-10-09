import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SchoolManagementMethods {
    private static  HashMap<String, Teacher> teacherHashMap;
    private static HashMap<String, Student> studentHashMap;
    private static HashMap<String, Course> courseHashMap;
    public static  Scanner scanner = new Scanner(System.in);
    public static String getValidStringInput(String promptToAskUser){
        String stringInput;
        while (true){
            //take user input
            System.out.print(promptToAskUser);
            stringInput = scanner.next();

            //if user input is empty or too short
            if( stringInput.length() >= 3 ) break;
            else System.out.println("Invalid Input! Name must be at least 3 character");


        }return stringInput;
    }
    public static int getValidIntegerInput(String promptToAskUser){

        int integerInput;
        while (true){
            try{
                //take user input
                System.out.print(promptToAskUser);
                integerInput = scanner.nextInt();

                //if user input is negative
                if(integerInput >= 0) break;
                else System.out.println("Invalid input. You must enter positive integer number");

                //if user input is non-integer, handle the exception
            }catch (InputMismatchException e){

                System.out.println("Invalid input. You must enter positive integer number");
                //delete the invalid input from scanner
                scanner.next();
            }
        }return integerInput;
    }
    public static double getValidDoubleInput(String promptToAskUser){
        double doubleInput;
        while (true){
            try{
                //take user input
                System.out.print(promptToAskUser);
                doubleInput = scanner.nextDouble();

                //if user input is negative
                if(doubleInput >= 0) break;
                else System.out.println("Invalid input. You must enter positive double number");

                //if user input is non-double, handle the exception
            }catch (InputMismatchException e){

                System.out.println("Invalid input. You must enter positive double number");
                //delete the invalid input from scanner
                scanner.next();
            }
        }return doubleInput;
    }
    public static String getValidEmail(String promptToAskUser){
        String inputEmail;
        while (true) {

            //get email from user
            System.out.print(promptToAskUser);
            inputEmail = scanner.next().trim();

            if (inputEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) break;
            else System.out.println("Invalid email address. Please enter a valid email.");


        }
        return inputEmail;
    }
    public static void setUpSchool(){

        //Hash map to store the details of teachers, student, and courses.
        teacherHashMap = new HashMap<>();
        studentHashMap = new HashMap<>();
        courseHashMap =  new HashMap<>();

        //Getting school name from user
        String schoolName = getValidStringInput("Enter the name of the school: ");

        //Getting the  number of teachers from user
        int numTeachers = getValidIntegerInput("Enter the number of teachers: ");

        //Getting teachers' details
        for (int i=0; i < numTeachers; i++){

            System.out.println("Enter details for Teacher " + (i + 1) + ":");
            String teacherName = getValidStringInput("Name: ");
            double teacherSalary = getValidDoubleInput("Salary: ");

            //create new teacher
            Teacher teacher = new Teacher(teacherName,teacherSalary);
            //add a teacher in the hashMap
            teacherHashMap.put(teacher.getTeacherId(),teacher);

        }

        //Getting the  number of courses from user
        int numCourses = getValidIntegerInput("Enter the number of courses: ");

        //Getting Courses' details
        for (int i=0; i < numCourses; i++){

            System.out.println("Enter details for course " + (i + 1) + ":");
            String courseName = getValidStringInput("Name: ");
            double coursePrice = getValidDoubleInput("Price: ");

            //create new course
            Course course = new Course(courseName,coursePrice);
            //add a course in the hashMap
            courseHashMap.put(course.getCourseId(),course);

        }

        //Getting the  number of students from user
        int numStudent = getValidIntegerInput("Enter the number of students: ");

        //Getting Students' details
        for (int i=0; i < numStudent; i++){

            System.out.println("Enter details for student " + (i + 1) + ":");
            String studentName = getValidStringInput("Name: ");
            String studentAddress = getValidStringInput("Address: ");
            String studentEmail = getValidEmail("Email: ");


            //create new student
            Student student = new Student(studentName,studentAddress,studentEmail);
            //add a student in the hashMap
            studentHashMap.put(student.getStudentId(),student);


        }

        System.out.println("\nWelcome in " + schoolName + " School!");

        //display the available commands to the user
        System.out.println("\n------------------------Available Commands--------------------------\n");
        System.out.println("1. ENROLL [STUDENT_ID] [COURSE_ID]"+
                "\n2. ASSIGN [TEACHER_ID] [COURSE_ID]"+
                "\n3. SHOW COURSES"+
                "\n4. LOOKUP COURSE [COURSE_ID]"+
                "\n5. SHOW STUDENTS"+
                "\n6. LOOKUP STUDENT [STUDENT_ID]"
                +"\n7. SHOW TEACHERS"
                +"\n8. LOOKUP TEACHER [TEACHER_ID]"
                +"\n9. SHOW PROFIT");
    }
    public static void processUserCommands(){

        //Getting user's command
        System.out.println("Please enter a command:");
        String command = scanner.nextLine();


        //Split the input commands to identify the corresponding actions
        String[] commandPortions = command.split(" ");
        switch (commandPortions[0].toUpperCase()){

            case "ENROLL":
                enrollStudent(commandPortions[1],commandPortions[2]);
                break;

            case "ASSIGN":
                assignTeacher(commandPortions[1],commandPortions[2]);
                break;

            case "LOOKUP":
                //Determined what to lookup for
                switch (commandPortions[1].toUpperCase()){
                    case "COURSE":
                        lookupCourse(commandPortions[2]);
                        break;
                    case "STUDENT":
                        lookupStudent(commandPortions[2]);
                        break;
                    case "TEACHER":
                        lookupTeacher(commandPortions[2]);
                        break;

                    default:
                        System.out.println("Invalid Input! Please try again...");
                        processUserCommands();
                }
                break;

            case "SHOW":
                //determined what to show
                switch (commandPortions[1].toUpperCase()){
                    case "COURSES":
                        showCourses();
                        break;
                    case "STUDENTS":
                        showStudents();
                        break;
                    case "TEACHERS":
                        showTeachers();
                        break;
                    case "PROFIT":
                        showProfit();
                        break;
                    default:
                        System.out.println("Invalid Input! Please try again...");
                        processUserCommands();
                }
                break;

            default:
                System.out.println("Invalid Input! Please try again...");
                processUserCommands();

        }
    }
    public static void enrollStudent(String studentId, String courseId) {

        // Check if the student and course exist in the HashMaps
        if (studentHashMap.containsKey(studentId) && courseHashMap.containsKey(courseId)) {

            Student student = studentHashMap.get(studentId);
            Course course = courseHashMap.get(courseId);

            // Check if the student is already enrolled in a course
            if (student.getCourse() != null) System.out.println("Student is already enrolled in a course.");

            // Enroll the student in the course
            student.setCourse(course);

            // Update the money_earned of the course
            course.setMoney_earned(course.getMoney_earned()+ course.getPrice());

            System.out.println("Student " + student.getName() + " has been enrolled in course " + course.getName() + ".");
        } else System.out.println("Invalid student ID or course ID.");

    }
    public static void assignTeacher(String teacherId, String courseId) {

        // Check if the teacher and course exist in the HashMaps
        if (teacherHashMap.containsKey(teacherId) && courseHashMap.containsKey(courseId)) {

            Teacher teacher = teacherHashMap.get(teacherId);
            Course course = courseHashMap.get(courseId);

            // Assign the teacher to the course
            course.setTeacher(teacher);
            System.out.println("Teacher " + teacher.getName() + " has been assigned to course " + course.getName() + ".");
        } else System.out.println("Invalid teacher ID or course ID.");
    }
    public static void showCourses(){

        //if there is no courses in the system.
        if(courseHashMap.isEmpty()) System.out.println("No Course found!");
        else{
            System.out.println("List of Courses:");
            courseHashMap.values().forEach(System.out::println);
        }
    }
    public static void lookupCourse(String courseId){

        Course course = courseHashMap.get(courseId);
        if (course != null) System.out.println(course);
        else System.out.println("Course not found. Please enter a valid course ID.");

    }
    public static void showStudents(){

        //if there is no students in the system.
        if(studentHashMap.isEmpty()) System.out.println("No student found!");
        else{
            System.out.println("List of Students:");
            studentHashMap.values().forEach(System.out::println);
        }
    }
    public static void lookupStudent(String studentId){

        Student student = studentHashMap.get(studentId);

        // Check if the student exists in the studentHashMap
        if (student != null) System.out.println(student);
        else System.out.println("Student not found. Please enter a valid student ID.");

    }
    public static void showTeachers(){

        //if there is no teachers in the system.
        if(teacherHashMap.isEmpty()) System.out.println("No Teacher found!");
        else{
            System.out.println("List of Teachers:");
            teacherHashMap.values().forEach(System.out::println);
        }
    }
    public static void lookupTeacher(String teacherId){

        Teacher teacher = teacherHashMap.get(teacherId);
        // Check if the teacher exists in the teacherHashMap
        if (teacher != null) System.out.println(teacher);
        else System.out.println("Teacher not found. Please enter a valid teacher ID.");

    }
    public static void showProfit(){
        double totalMoneyEarned = 0;
        double totalTeacherSalaries = 0;

        // Calculate the total money earned from all courses
        for (Course course : courseHashMap.values()) {
            totalMoneyEarned += course.getMoney_earned();
        }

        // Calculate the sum of all the teachers' salaries
        for (Teacher teacher : teacherHashMap.values()) {
            totalTeacherSalaries += teacher.getSalary();
        }

        // Calculate the profit
        double profit = totalMoneyEarned - totalTeacherSalaries;

        // Display the profit to the user
        System.out.println("Profit: $" + profit);
    }

}