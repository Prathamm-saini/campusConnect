package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome Student " + name);
    }

    public void enrollInCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            System.out.println("Already enrolled in: " + course.getCourseName());
        } else {
            enrolledCourses.add(course);
            System.out.println("✅ Enrolled in " + course.getCourseName());
        }
    }

    public void viewEnrolledCourses() {
        System.out.println("📚 Your Courses:");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No enrolled courses.");
            return;
        }
        for (Course c : enrolledCourses) {
            System.out.println("- " + c);
        }
    }
}
