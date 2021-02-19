package HomeWork4.students;

public class StudentsPrinter {

    public void printStudents(Student[] students, int i) {
        switch (i) {
            case 3:
                for (Student student : students) {
                    printStudentFullInfo(student);
                }
                break;
        }
    }

    public void printStudentFullInfo(Student student) {
        System.out.println(student.toString() + "\n");
    }
}
