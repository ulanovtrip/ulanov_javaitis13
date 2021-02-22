package HomeWork4;



import HomeWork4.courses.Course;
import HomeWork4.tutors.Tutor;

import java.util.Random;

public class CourseTutorAutoMatcher {

    public CourseTutorAutoMatcher() {
        this.random = new Random();
    }

    private Random random;

    public void autoMatch(Course[] courses, Tutor[] tutors) {
        //мы должны проставить каждому курсу перподавателя - перебираем все курсы
        for (Course course : courses) {
            //выбираем курсу рандомного преподавателя из списка преподавателей
            course.setTutor(tutors[random.nextInt(tutors.length)]);
            //проверяем есть ли у преподавателя список курсов вообще (изначально он не создаётся)
            if (course.getTutor().getCourses() == null) {
                //если списка нет создаём сновый список курсов
                Course courseListToSet[] = new Course[courses.length];
                //ставим на 0 позицию наш новый курс
                courseListToSet[0] = course;
                //отдаём нашему преподавателю список его курсов
                course.getTutor().setCourses(courseListToSet);
            } else {
                //если список есть нужно просто добавить ему курс
                Course[] courseArray = course.getTutor().getCourses();
                //флаг который говорит нам добавлен курс или нет
                boolean wasSet = false;
                for (int i = 0; i < courseArray.length; i++) {
                    //находим первую свободную позицию в массиве чтобы добавить туда курс
                    if (courseArray[i] == null) {
                        //добавляем курс
                        courseArray[i] = course;
                        //меняем флаг
                        wasSet = true;
                        break;
                    }
                }
                //если курс не был добавлен в лист - значит позиций в листе не хватает
                if (!wasSet) {
                    //создаём лист размером в двое больше чем предыдущий чтобы теперь точно поместилось
                    Course[] extendedCourseList = getExtendedCourseList(courseArray);
                    //добавляем в новом массиве на первую свободную позицию курс, которому мы сейчас проставили преподавателя
                    extendedCourseList[courseArray.length] = course;
                    //устанавливаем новый лист курсов преподавателю
                    course.getTutor().setCourses(extendedCourseList);
                }
            }
        }
    }

    private Course[] getExtendedCourseList(Course[] courseArray) {
        Course[] resultExtendedCourseList = new Course[courseArray.length * 2];
        //при создании копируем все значения из предыдущего списка в новый
        for (int i = 0; i < courseArray.length; i++) {
            resultExtendedCourseList[i] = courseArray[i];
        }
        return resultExtendedCourseList;
    }
}
