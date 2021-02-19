package HomeWork4.statistic;

import itis.oop.courses.CourseScore;

public class PrintRatingCourses {
    public void printRatingCourses(CourseScore[] courseScores) {

        for (CourseScore courseScore : courseScores) {
            System.out.println(courseScore.toString());
        }
    }
}
