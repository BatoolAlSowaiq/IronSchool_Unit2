import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SchoolManagementMethods {

    //Hash map to store the details of teachers, student, and courses.
    public static  HashMap<String, Teacher> teacherHashMap = new HashMap<>();
    public static HashMap<String, Student> studentHashMap = new HashMap<>();
    public static HashMap<String, Course> courseHashMap = new HashMap<>();

    public static String getValidStringInput(String promptToAskUser){

        Scanner scanner = new Scanner(System.in);
        String stringInput;
        while (true){
            //take user input
            System.out.print(promptToAskUser);
            stringInput = scanner.nextLine();

            //if user input is empty or too short
            if( stringInput.length() >= 3 ) break;
            else {System.out.println("Invalid Input! Name must be at least 3 character");}

        }return stringInput;
    }
    public static int getValidIntegerInput(String promptToAskUser){

        Scanner scanner = new Scanner(System.in);
        int integerInput;
        while (true){
            try{
                //take user input
                System.out.print(promptToAskUser);
                integerInput = scanner.nextInt();

                //if user input is negative
                if(integerInput >= 0) break;
                else {System.out.println("Invalid input. You must enter positive integer number");}

                //if user input is non-integer, handle the exception
            }catch (InputMismatchException e){

                System.out.println("Invalid input. You must enter positive integer number");
                //delete the invalid input from scanner
                scanner.next();
            }
        }return integerInput;
    }
    public static double getValidDoubleInput(String promptToAskUser){
        Scanner scanner = new Scanner(System.in);
        double doubleInput;
        while (true){
            try{
                //take user input
                System.out.print(promptToAskUser);
                doubleInput = scanner.nextDouble();

                //if user input is negative
                if(doubleInput >= 0) break;
                else {System.out.println("Invalid input. You must enter positive double number");}

                //if user input is non-double, handle the exception
            }catch (InputMismatchException e){

                System.out.println("Invalid input. You must enter positive double number");
                //delete the invalid input from scanner
                scanner.next();
            }
        }return doubleInput;
    }
    public static String getValidEmail(String promptToAskUser){
        Scanner scanner = new Scanner(System.in);
        String inputEmail;
        while (true) {

            //get email from user
            System.out.print(promptToAskUser);
            inputEmail = scanner.nextLine().trim();

            if (inputEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) break;
            else {System.out.println("Invalid email address. Please enter a valid email.");}


        }
        return inputEmail;
    }
    public static void setUpSchool(){


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
        System.out.println();
    }
    public static void processUserCommands(){
        Scanner scanner = new Scanner(System.in);
        //Getting user's command
        System.out.println("Please enter your command:");
        String command = scanner.nextLine();


        //Split the input commands to identify the corresponding actions
        String[] commandPortions = command.trim().split(" ");
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
                        lookupValueById(courseHashMap,"course",commandPortions[2]);
                        break;
                    case "STUDENT":
                        lookupValueById(studentHashMap,"student",commandPortions[2]);
                        break;
                    case "TEACHER":
                        lookupValueById(teacherHashMap,"teacher",commandPortions[2]);
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
                        showAllValue(courseHashMap, "course");
                        break;
                    case "STUDENTS":
                        showAllValue(studentHashMap, "student");
                        break;
                    case "TEACHERS":
                        showAllValue(teacherHashMap, "teacher");
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
            course.updateMoneyEarned();
            System.out.println(course.getMoney_earned());


            System.out.println("Student " + student.getName() + " has been enrolled in course " + course.getName() + ".");
        } else {System.out.println("Invalid student ID or course ID.");}

    }
    public static void assignTeacher(String teacherId, String courseId) {

        // Check if the teacher and course exist in the HashMaps
        if (teacherHashMap.containsKey(teacherId) && courseHashMap.containsKey(courseId)) {

            Teacher teacher = teacherHashMap.get(teacherId);
            Course course = courseHashMap.get(courseId);

            // Assign the teacher to the course
            course.setTeacher(teacher);
            System.out.println("Teacher " + teacher.getName() + " has been assigned to course " + course.getName() + ".");
        } else {System.out.println("Invalid teacher ID or course ID.");}
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
        double profit = totalMoneyEarned - (totalTeacherSalaries);

        // Display the profit to the user
        System.out.println("Profit: $" + profit);
    }
    public static <T> void showAllValue(HashMap<String, T> hashMap, String type) {
        /*
          <T>: This is a generic type parameter declaration,
          which allows us to use a placeholder type T in the method signature.
          This  ensures that the method can handle different types of objects stored in the HashMap.
        */
        if (hashMap.isEmpty()) System.out.println("No " + type + " found!");
        else {
            System.out.println("List of " + type + ":");
            hashMap.values().forEach(System.out::println);
        }
    }
    public static <T> void lookupValueById(HashMap<String, T> hashMap, String type, String id) {
        /*
          <T>: This is a generic type parameter declaration,
          which allows us to use a placeholder type T in the method signature.
          This  ensures that the method can handle different types of objects stored in the HashMap.
        */

        // Check if the student exists in the studentHashMap
        if (hashMap.get(id) != null) System.out.println(hashMap.get(id));
        else {System.out.println(type + " not found. Please enter a valid student ID.");}

    }

}
