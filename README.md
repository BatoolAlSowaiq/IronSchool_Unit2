# IronSchool_Unit2

# School Management System

The School is a Java program that contain students, teachers and courses it allow to user to enroll in the school and register for courses and assign teachers to courses and so on.

## Classes

# SchoolManagementSystem Class
The `SchoolManagementSystem` class is the main class in which the system is operated and the continuity of the user's use of the system is controlled.


# SchoolManagementMethods Class
The `SchoolManagementMethods`class was created to keep main class clean and to put all static methods in it so that it becomes a reference or a library of tools and we used the hashmap to improve our data management and improve the efficiency of the software as well as speed up the processes and store all details of student, course, teacher class.

## Methods
- `getValidStringInput(String promptToAskUser)`: This methode is responsible forerifying the authenticity of the user's String input.
- `getValidIntegerInput(String promptToAskUser)`: This methode is responsible forerifying the authenticity of the user's integer-type input.
- `getValidDoubleInput(String promptToAskUser)`:This methode is responsible forerifying the authenticity of the user's double-type input.
- `getValidEmail(String promptToAskUser)`: This methode is responsible for verifying the authenticity of the email entered by the user.
- `setUpSchool()`:This methode is responsible for taking details of teachers, students and courses from the user and viewing the command available to the user.
- `processUserCommands()`: This methode is responsible for validating and processing user input for commands.
- `enrollStudent(String studentId, String courseId)`: This methode is responsible for validating students' enrolment in courses.
- `assignTeacher(String teacherId, String courseId)`: This methode is responsible for the assign teacher in the courses.
- `showProfit()`: This methode is responsible for calculating the profit and displaying it to the user.
- `showAllValue(HashMap<String, T> hashMap, String type) `: This methode ensures that the method can handle different types of objects stored in the HashMap.
- `lookupValueById(HashMap<String, T> hashMap, String type, String id)`: This methode ensures that the method can handle different types of objects stored in the HashMap.


# Student Class
The `Student` class represents a student in a school. It has the following properties:

- `studentId`: A unique identifier generated using the `generateStudentID()` method.
- `name`: The name of the student.
- `address`: The address of the student.
- `email`: The email address of the student.
- `course`: The course that the student is enrolled in. It can be `null` if the student is not enrolled in any course.
- `studentCounter`: A static variable used to keep track of the number of students created.

## Constructors
- `Student(String name, String address, String email)`: Creates a new `Student` object with the given name, address, and email. The `studentId` is generated using the `generateStudentID()` method, and the `course` is initially set to `null`.

## Methods
- `getName()`: Returns the name of the student.
- `setName(String name)`: Sets the name of the student.
- `getAddress()`: Returns the address of the student.
- `setAddress(String address)`: Sets the address of the student.
- `getEmail()`: Returns the email address of the student.
- `setEmail(String email)`: Sets the email address of the student.
- `getCourse()`: Returns the course that the student is enrolled in.
- `setCourse(Course course)`: Sets the course that the student is enrolled in.


# Course Class
The `Course` class represents a course offered by a school. It has the following properties:

- `courseId`: A unique identifier generated using the `generateCourseID()` method.
- `name`: The name of the course.
- `price`: The price of the course.
- `money_earned`: The total amount of money earned from the course.
- `teacher`: The teacher assigned to the course.
- `courseCounter`: A static variable used to keep track of the number of courses created.

## Constructors
- `Course(String name, double price)`: Creates a new `Course` object with the given name and price. The `courseId` is generated using the `generateCourseID()` method, and the `money_earned` is initially set to 0. The `teacher` is initially set to `null`.

## Methods
- `getName()`: Returns the name of the course.
- `setName(String name)`: Sets the name of the course.
- `getPrice()`: Returns the price of the course.
- `setPrice(double price)`: Sets the price of the course.
- `getMoney_earned()`: Returns the total amount of money earned from the course.
- `updateMoneyEarned()`: Updates the `money_earned` property by adding the price of the course.
- `getTeacher()`: Returns the teacher assigned to the course.
- `setTeacher(Teacher teacher)`: Sets the teacher assigned to the course.


# Teacher Class
The `Teacher` class  a Teacher in a school. It has the following properties:

- `teacherId`: A unique identifier generated using the `generateTeacherID()` method.
- `name`: The name of the teacher.
- `salary`: The salary for the teacher.
- `teacherCounter`: A static variable used to keep track of the number of teachers created.

## Constructors
` Teacher(String name, double salary)`: Creates a new `Teacher` object with the given name and salary. The `teacherId` is generated using the `generateTeacherID()` method.

## Methods
- `getName()`: Returns the name of the teacher.
- `setName(String name)`: Sets the name of the teacher.
- `getSalary()`: Returns the salary for the teacher.
- `setSalary(double salary)`: Sets the salary for the teacher.


# How the application works
1. Compile the Java files using a Java compiler.
2. Run the compiled program by executing the `SchoolManagementSystem` class.
3. Once you run it,The program will ask you to Enter the name of the school: .
4. Enter the name of the school you want and make sure that you enter name in string type!
5. Once you Enter the school name then The program will ask you to Enter the number of teachers: (make sure that you enter a positive integer number)
6. Once you Enter the number of teachers then The program will ask you to Enter the details for Teacher like name and salary.
7. Once you Enter the details for Teacher The program will ask you to Enter the number of courses and all details for courses like name and price.
8. Once you Enter the details for the courses The program will ask you to Enter the number of students details for student like name (more than 3 letters) ,address and email(make sure that you write in a correct way).
9. Then the program will display Welcome in (name of school) School! and show the Available Commands.
10. Once you Enter your command the program will Process your command then ask you if you want to continue the program.
    - if you chose y (yes) then you must chose command again.
    -  if you chose n (no) the program will display this message (Thank you for Using our School Management System! Goodbye!).
11. the end of the program!
    
## Credits
The School Project is developed by Batool AlSowaiq, Raghad Aljohani, Lujain Abdullah alghandi, Afaf Abdullah and Yumna Alansari.
