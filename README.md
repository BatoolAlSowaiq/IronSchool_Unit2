# IronSchool_Unit2

# School

The School is a Java program that contain students, teachers and courses it allow to user to enroll in the school and register for courses and assign teachers to courses and so on.

## Classes

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

