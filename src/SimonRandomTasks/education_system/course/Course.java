package SimonRandomTasks.education_system.course;

import SimonRandomTasks.education_system.student.Student;
import SimonRandomTasks.education_system.tutor.Tutor;

public class Course {

    private String nameOfCourse;
    private Integer valueOfHours;
    private Tutor tutor;
    private Student[] students;

    public Course(String nameOfCourse, Integer valueOfHours, Tutor tutor, Student[] students) {
        this.nameOfCourse = nameOfCourse;
        this.valueOfHours = valueOfHours;
        this.tutor = tutor;
        this.students = students;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public Integer getValueOfHours() {
        return valueOfHours;
    }

    public void setValueOfHours(Integer valueOfHours) {
        this.valueOfHours = valueOfHours;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
