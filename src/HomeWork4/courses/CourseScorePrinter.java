package HomeWork4.courses;

public class CourseScorePrinter {
    public void printCourses(CourseScore[] courseScores, int i) {
        switch (i) {
            case 3:
                for (CourseScore courseScore : courseScores) {
                    printCoursesFullInfo(courseScore);
                }
                break;
        }
    }

    public void printCoursesFullInfo(CourseScore courseScore) {
        System.out.println(courseScore.toString());
    }
}
