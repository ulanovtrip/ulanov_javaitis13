package SimonRandomTasks.education_system.tutor;

import SimonRandomTasks.education_system.course.Course;

public class Tutor {

    private String firstName;
    private String lastName;
    private Course[] courses;
    private Double salary;

    public Tutor(String firstName, String lastName, Course[] courses, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
