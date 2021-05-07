package HomeWork4.students;


import HomeWork4.courses.Course;
import HomeWork4.courses.CourseScore;
import HomeWork4.courses.CourseScoreGenerate;

import java.util.Random;

public class StudentGenerator {

    public static String[] names = {
            "Никита Матвеев",
            "Евгений Степанов",
            "Вера Романова",
            "Адуля Новикова",
            "София Савина",
            "Илья Никулин",
            "Ольга Лебедева",
            "Алёна Емельянова",
            "Анна Васильева",
            "Святослав Зубков",
            "Руслан Кочетков",
            "Матвей Григорьев",
            "Арина Давыдова",
            "Ярослав Наумов",
            "Екатерина Софронова",
            "Кира Петрова",
            "Вера Ермолова",
            "Михаил Елисеев",
            "Павел Смирнов",
            "Иван Петров",
            "Иван Усов",
            "Таисия Федорова",
            "Тимур Антонов",
            "Ярослав Фролов",
            "Полина Мартынова",
            "Владимир Куликов",
            "Ангелина Данилова",
            "Анна Муравьева",
            "Ангелина Бирюкова",
            "Анна Денисова",
            "Илья Богомолов",
            "Михаил Иванов",
            "Софья Михайло",
            "Никита Матвеев",
            "Евгений Степанов",
            "Вера Романова",
            "Адуля Новикова",
            "София Савина",
            "Илья Никулин",
            "Ольга Лебедева",
            "Алёна Емельянова",
            "Анна Васильева",
            "Святослав Зубков",
            "Руслан Кочетков",
            "Матвей Григорьев",
            "Арина Давыдова",
            "Ярослав Наумов",
            "Екатерина Софронова",
            "Кира Петрова",
            "Вера Ермолова",
            "Михаил Елисеев",
            "Павел Смирнов",
            "Иван Петров",
            "Иван Усов",
            "Таисия Федорова",
            "Тимур Антонов",
            "Ярослав Фролов",
            "Полина Мартынова",
            "Владимир Куликов",
            "Ангелина Данилова",
            "Анна Муравьева",
            "Ангелина Бирюкова",
            "Анна Денисова",
            "Илья Богомолов",
            "Михаил Иванов",
            "Софья Михайло"
    };

    String[] groupNames = {
            "1A",
            "2B",
            "3G",
            "3Z",
            "Q6",
    };

    private Random random;

    public StudentGenerator() {
        this.random = new Random();
    }

    public Student[] getStudents(int n, CourseScore[] courseScores, Course[] courses) {
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = getStudent(courseScores, courses);
        }
        return students;
    }

    public Student getStudent(CourseScore[] courseScores, Course[] courses) {
        return new Student(
                names[random.nextInt(40)],
                16 + random.nextInt(2),
                groupNames[random.nextInt(5)],
                new CourseScoreGenerate().getCourseScores(courses)
        );
    }
}
