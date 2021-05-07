package SimonRandomTasks.education_system.student;

import SimonRandomTasks.education_system.course.CourseScore;

import java.security.SecureRandom;

public class Student {

    private String fio;
    private Integer age;
    private String group;
    private CourseScore[] courseScores;
    SecureRandom random;

    public Student(String fio, Integer age, String group, CourseScore[] courseScores) {
        this.fio = fio;
        this.age = age;
        this.group = group;
        this.courseScores = courseScores;
        random = new SecureRandom();
    }

    public Student[] generateStudents(int size) {

        Student[] students = new Student[size];

        // TODO: 05.05.2021
        return students;
    }

    public Student generateStudent() {
//        Student generatedStudent = new Student(
//                // TODO: 05.05.2021
//        );

        //return generatedStudent;
        return null;
    }

    public String getFirstName() {
        return fio;
    }

    public void setFirstName(String firstName) {
        this.fio = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public CourseScore[] getCourseScores() {
        return courseScores;
    }

    public void setCourseScores(CourseScore[] courseScores) {
        this.courseScores = courseScores;
    }
}
