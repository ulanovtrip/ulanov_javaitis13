package HomeWork4;

import HomeWork4.courses.*;
import HomeWork4.statistic.PrintRatingCourses;
import HomeWork4.statistic.PrintRatingStudents;
import HomeWork4.statistic.PrintRatingTutors;
import HomeWork4.students.Student;
import HomeWork4.students.StudentGenerator;
import HomeWork4.students.StudentsPrinter;
import HomeWork4.tutors.Tutor;
import HomeWork4.tutors.TutorGenerator;
import HomeWork4.tutors.TutorPrinter;


public class Main {
    public static void main(String[] args) {
        TutorGenerator tutorGenerator = new TutorGenerator();
        CourseGenerator courseGenerator = new CourseGenerator();
        StudentGenerator studentGenerator = new StudentGenerator();
        CourseScoreGenerate courseScoreGenerate = new CourseScoreGenerate();

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
