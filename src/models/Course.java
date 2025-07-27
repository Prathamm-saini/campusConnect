package models;

public class Course {
    private String courseId;
    private String courseName;
    private String instructor;

    public Course(String courseId, String courseName, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return courseId + " - " + courseName + " by " + instructor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return this.courseId.equalsIgnoreCase(other.courseId);
    }

    @Override
    public int hashCode() {
        return courseId.toLowerCase().hashCode();
    }
}
