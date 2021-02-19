package HomeWork4.tutors;

import HomeWork4.courses.Course;

public class Tutor {
    private String fullName;
    private int age;
    private Course[] courses;
    private double salary;

    @Override
    public String toString() {
        return "Tutor {" +
                " fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Tutor(String fullName, int age, Course[] courses, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.courses = courses;
        this.salary = salary;
    }

    public Tutor(String fullName, int age, double salary) {
        this(fullName, age, null, salary);
    }

    public Tutor(String fullName, int age) {
        this(fullName, age, null, 15000d);
    }


    public String getCoursesInfo() {
        if (courses == null) return null;
        StringBuilder result = new StringBuilder();
        for (Course course : courses) {
            if (course != null) {
                result.append(course.getName() + " " + course.getHours() + " " + " students: " + course.getStudentInfo() + " \n");
            }
        }
        return result.toString();
    }
}
