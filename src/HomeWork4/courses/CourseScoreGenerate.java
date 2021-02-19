package HomeWork4.courses;

import java.util.Random;

public class CourseScoreGenerate {

    private Random random;

    public CourseScoreGenerate() {
        this.random = new Random();
    }

    public CourseScore[] getCourseScores(Course[] courses) {
        CourseScore[] courseScores = new CourseScore[courses.length];

        for (int i = 0; i < courses.length; i++) {
            courseScores[i] = new CourseScore(courses[random.nextInt(courses.length)], random.nextDouble() * 10);
        }
        return courseScores;
    }
}
