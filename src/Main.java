import models.*;
import services.CourseManager;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CourseManager courseManager = new CourseManager();

    public static void main(String[] args) {
        System.out.println("=== Welcome to CampusConnect ===");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.println("Select Role: \n1. Student \n2. Professor \n3. Admin");
        int role = Integer.parseInt(scanner.nextLine());

        User user;

        if (role == 1) {
            user = new Student(name, email);
        } else if (role == 2) {
            user = new Professor(name, email);
        } else if (role == 3) {
            user = new Admin(name, email);
        } else {
            throw new IllegalArgumentException("Invalid role selected.");
        }

        user.showDashboard();
        roleMenu(user);
        System.out.println("Logged out. Thank you for using CampusConnect.");
    }

    private static void roleMenu(User user) {
        boolean exit = false;
        while (!exit) {
            if (user instanceof Admin) {
                System.out.println("\nAdmin Menu:\n1. Add Course\n2. View Courses\n3. Logout");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    addCourse();
                } else if (choice == 2) {
                    courseManager.showCourses();
                } else if (choice == 3) {
                    exit = true;
                } else {
                    System.out.println("Invalid option.");
                }
            } else if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println("\nStudent Menu:\n1. View All Courses\n2. Enroll in Course\n3. My Courses\n4. Logout");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    courseManager.showCourses();
                } else if (choice == 2) {
                    enrollCourse(student);
                } else if (choice == 3) {
                    student.viewEnrolledCourses();
                } else if (choice == 4) {
                    exit = true;
                } else {
                    System.out.println("Invalid option.");
                }
            } else if (user instanceof Professor) {
                System.out.println("\nProfessor Menu:\n1. View Courses\n2. Logout");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    courseManager.showCourses();
                } else if (choice == 2) {
                    exit = true;
                } else {
                    System.out.println("Invalid option.");
                }
            }
        }
    }

    private static void addCourse() {
        System.out.print("Enter Course ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Instructor: ");
        String instructor = scanner.nextLine();

        courseManager.addCourse(new Course(id, name, instructor));
    }

    private static void enrollCourse(Student student) {
        System.out.print("Enter Course ID to Enroll: ");
        String courseId = scanner.nextLine();
        Course course = courseManager.findCourseById(courseId);
        if (course != null) {
            student.enrollInCourse(course);
        } else {
            System.out.println("❌ Course not found.");
        }
    }
}
