package HomeWork4.statistic;

import HomeWork4.courses.Course;
import HomeWork4.tutors.Tutor;

import java.util.HashMap;
import java.util.Map;

public class PrintRatingTutors {

    public void printStatisticTutors(Tutor[] tutors) {
        Map<String, Integer> map = new HashMap<>();

        for (Tutor tutor : tutors) {
            Course[] currentCountCourses = tutor.getCourses();

            if (currentCountCourses != null) {
                map.put(tutor.getFullName(), currentCountCourses.length);
            }
        }

        System.out.println(map.toString());
    }
}
