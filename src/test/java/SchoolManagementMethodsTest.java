import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SchoolManagementMethodsTest {

    @Test
    void getValidStringInput_validString_correctStringInput() {

        // Simulate user input
        String input = "Test Input";
        //convert the input to byte stream
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        //set the input stream to system.in
        System.setIn(inputStream);

        //call the
        String result = SchoolManagementMethods.getValidStringInput("Enter a valid string: ");

        assertEquals("Test Input", result);
    }
    @Test
    void getValidStringInput_inValidString_loopUntilCorrectStringInput() {

        // First Iteration will get invalid String
        // will ask the user again,until get valid input
        String input = "AB\nA\nBatool AlSowaiq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        String promptToAskUser = "Enter a valid string: ";
        String result = SchoolManagementMethods.getValidStringInput(promptToAskUser);

        assertEquals("Batool AlSowaiq", result);


    }

    @Test
    void getValidIntegerInput_validPositiveInt_correctPositiveIntegerInput() {

            // Simulate user input
            String input = "5";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            //get the valid integer
            int result = SchoolManagementMethods.getValidIntegerInput("Enter a valid integer: ");

            System.out.println(result);
            assertEquals(5, result);

    }

    @Test
    void getValidIntegerInput_invalidInput_loopUntilCorrectPositiveIntegerInput() {

        // Simulate user input
        String input = "-1\nBatool\n5";
        //convert the input to byte stream
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        //set the input stream to system.in
        System.setIn(inputStream);

        //get the valid integer
        int result = SchoolManagementMethods.getValidIntegerInput("Enter a valid integer: ");

        System.out.println(result);
        assertEquals(5, result);

    }

    @Test
    void getValidDoubleInput_validPositiveDouble_correctDoubleInput() {
        String input = "10.5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        String promptToAskUser = "Enter a valid double: ";

        double result = SchoolManagementMethods.getValidDoubleInput(promptToAskUser);
        assertEquals(10.5, result, 0.0001);
    }
    @Test
    void getValidDoubleInput_inValidInput_loopUntilCorrectDoubleInput() {
        String input = "c\n-1\n-3.5\n10.5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        String promptToAskUser = "Enter a valid double: ";

        double result = SchoolManagementMethods.getValidDoubleInput(promptToAskUser);
        assertEquals(10.5, result, 0.0001);
    }

    @Test
    void getValidEmail_validInput_correctEmail() {
        String input = "test@example.com\n"; // Provide a valid email address for testing (with a newline character)
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        String promptToAskUser = "Enter your email: ";

        String result = SchoolManagementMethods.getValidEmail(promptToAskUser);

        assertEquals("test@example.com", result);
    }
    @Test
    void getValidEmail_inValidInput_loopUntilCCorrectEmail() {

        // Provide an invalid email address followed by a valid email address (with newline characters)
        String input = "invalidemail\nvalidemail@example.com\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);


        String result = SchoolManagementMethods.getValidEmail("Enter your email: ");
        // Assert that the returned email is equal to the expected valid email
        assertEquals("validemail@example.com", result);
    }
    @Test
    void enrollStudent_validID_successfullyEnrolled() {

        //create and add the course & student to the hashmap
        Student student = new Student("Batool AlSowaiq", "AlHasa","B290@outlook.com");
        Course course = new Course("Mathematics", 100.0);

        SchoolManagementMethods.courseHashMap.put(course.getCourseId(), course);
        SchoolManagementMethods.studentHashMap.put(student.getStudentId(), student);

        //check the totalMoneyEarned before enrollment
        double oldTotalMoneyEarned = course.getMoney_earned();

        //enroll the course
        SchoolManagementMethods.enrollStudent(student.getStudentId(),course.getCourseId());


        //check if the course is enrolled successfully
        assertEquals(student.getCourse(), course);

        //check if the totalMoneyEarned updated successfully
        assertEquals(oldTotalMoneyEarned+100,course.getMoney_earned());



    }
    @Test
    void enrollStudent_inValidID_notEnrolled() {

        //create and add the course & student to the hashmap
        Student student = new Student("Batool AlSowaiq", "AlHasa","B290@outlook.com");
        Course course = new Course("Mathematics", 100.0);

        SchoolManagementMethods.courseHashMap.put(course.getCourseId(), course);
        SchoolManagementMethods.studentHashMap.put(student.getStudentId(), student);

        //check the totalMoneyEarned before enrollment
        double oldTotalMoneyEarned = course.getMoney_earned();

        //pass invalid id
        SchoolManagementMethods.enrollStudent("ID",course.getCourseId());


        //check if the course is not enrolled
        assertEquals(null,student.getCourse());

        //check if the totalMoneyEarned still the same
        assertEquals(oldTotalMoneyEarned,course.getMoney_earned());



    }
    @Test
    void assignTeacher_validId_successfullyAssigned() {

        //create and add the teacher & course to the hashmap
        Course course = new Course("Mathematics", 100.0);
        Teacher teacher = new Teacher("Batool AlSowaiq",8000.0);

        SchoolManagementMethods.courseHashMap.put(course.getCourseId(), course);
        SchoolManagementMethods.teacherHashMap.put(teacher.getTeacherId(), teacher);

        System.out.println("Before assigning the teacher:");
        System.out.println(course);

        //pass valid teacher id
        SchoolManagementMethods.assignTeacher(teacher.getTeacherId(), course.getCourseId());

        // Print the updated state of the course
        System.out.println("After assigning the teacher:");
        System.out.println(course);

        //Check if the teacher is assigned
        assertEquals(teacher,course.getTeacher());

    }
    @Test
    void assignTeacher_inValidId_notAssigned() {

        //create and add the course to the hashmap
        Course course = new Course("Mathematics", 100.0);
        SchoolManagementMethods.courseHashMap.put(course.getCourseId(), course);

        System.out.println("Before assigning the teacher:");
        System.out.println(course);

        //pass invalid teacher id
        SchoolManagementMethods.assignTeacher("ID", course.getCourseId());

        // Print the updated state of the course
        System.out.println("After assigning the teacher:");
        System.out.println(course);

        //Check if the course teacher is empty
        assertEquals(null,course.getTeacher());

    }



}