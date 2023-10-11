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
    void getValidDoubleInput() {
    }

    @Test
    void getValidEmail() {
    }

    @Test
    void enrollStudent_validID_successfullyEnrolled() {

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