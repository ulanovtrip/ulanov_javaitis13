package HomeWork4.courses;

import HomeWork4.students.Student;
import itis.oop.tutors.Tutor;

import java.util.Arrays;

public class Course {
    private String name;
    private int hours;
    private Tutor tutor;
    private Student[] students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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

    public Course(String name, int hours, Tutor tutor, Student[] students) {
        this.name = name;
        this.hours = hours;
        this.tutor = tutor;
        this.students = students;
    }

    public Course(String name, int hours, Tutor tutor) {
        this(name, hours, tutor, null);
    }

    public Course(String name, int hours){
        this(name, hours, null, null);
    }

    @Override
    public String toString() {
        return "Course {" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", tutor=" + tutor +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public String getStudentInfo() {
        if(students == null) return null;
        StringBuilder result = new StringBuilder();
        for (Student student: students){
            if(student != null) {
                result.append("Student name: " + student.getFullName() + "; Age:" + student.getAge() + "/ " + student.getGroupName() + "/ " + student.getCourses());
            }
        }
        return result.toString();
    }
}
