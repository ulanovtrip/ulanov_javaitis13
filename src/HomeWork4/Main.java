package HomeWork4;

import itis.oop.courses.*;
import HomeWork4.statistic.PrintRatingCourses;
import HomeWork4.statistic.PrintRatingStudents;
import HomeWork4.statistic.PrintRatingTutors;
import itis.oop.students.Student;
import itis.oop.students.StudentGenerator;
import itis.oop.students.StudentsPrinter;
import itis.oop.tutors.Tutor;
import itis.oop.tutors.TutorGenerator;
import itis.oop.tutors.TutorPrinter;

public class Main {
    public static void main(String[] args) {
        TutorGenerator tutorGenerator = new TutorGenerator();
        CourseGenerator courseGenerator = new CourseGenerator();
        StudentGenerator studentGenerator = new StudentGenerator();
        CourseScoreGenerate  courseScoreGenerate = new CourseScoreGenerate();

        Tutor[] tutors = tutorGenerator.getTutors(20);
        Course[] courses = courseGenerator.getCourses(6);
        CourseScore[] courseScores = courseScoreGenerate.getCourseScores(courses);
        Student[] students = studentGenerator.getStudents(40, courseScores, courses);


        CoursePrinter coursePrinter = new CoursePrinter();
        TutorPrinter tutorPrinter = new TutorPrinter();
        StudentsPrinter studentsPrinter = new StudentsPrinter();
        CourseScorePrinter courseScorePrinter = new CourseScorePrinter();

        tutorPrinter.printTutors(tutors, 3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        coursePrinter.printCourses(courses, 3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        studentsPrinter.printStudents(students, 3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        courseScorePrinter.printCourses(courseScores, 3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        CourseTutorAutoMatcher courseTutorAutoMatcher = new CourseTutorAutoMatcher();
        courseTutorAutoMatcher.autoMatch(courses, tutors);
        System.out.println("==========================================================================================");
        tutorPrinter.printTutors(tutors, 3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        coursePrinter.printCourses(courses, 3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        PrintRatingCourses printRatingCourses = new PrintRatingCourses();
        printRatingCourses.printRatingCourses(courseScores);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        PrintRatingStudents printRatingStudents = new PrintRatingStudents();
        printRatingStudents.printRatingOfStudents(students);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        PrintRatingTutors printRatingTutors = new PrintRatingTutors();
        printRatingTutors.printStatisticTutors(tutors);
    }
}
