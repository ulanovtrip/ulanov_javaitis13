package HomeWork4.statistic;


import HomeWork4.courses.CourseScore;
import HomeWork4.students.Student;

public class PrintRatingStudents {

    public void printRatingOfStudents(Student[] students) {
        CourseScore[] currentCurses;
        double averageScore = 0;
        for (Student student : students) {
            double counter = 0;
            currentCurses = student.getCourses();
            for (int i = 0; i < currentCurses.length; i++) {
                double current = currentCurses[i].getScore();
                counter += current;
            }
            averageScore = counter / currentCurses.length;
            System.out.println(student.getFullName() + " " + averageScore);
        }
    }
}
