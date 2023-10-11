import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SchoolManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize and set up the school details
        SchoolManagementMethods.setUpSchool();

       do{
           //Get user command
            SchoolManagementMethods.processUserCommands();

            //Exit from School Management System
            System.out.println("Do You want to continue? (Y/N) : " );
            String input = scanner.next();

            if (input.trim().equalsIgnoreCase("N")) break;
        }while(true);

        System.out.println("Thank you for Using our School Management System! Goodbye!");
        scanner.close();
    }

}
