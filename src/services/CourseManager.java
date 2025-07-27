package services;


import models.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("✅ Course added: " + course);
    }

    public void showCourses() {
        System.out.println("📃 Available Courses:");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : courses) {
            System.out.println("- " + c);
        }
    }

    public Course findCourseById(String id) {
        for (Course c : courses) {
            if (c.getCourseId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
}
