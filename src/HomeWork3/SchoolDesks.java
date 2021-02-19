package HomeWork3;

import java.util.Scanner;

public class SchoolDesks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int schoolChildren = scanner.nextInt();

        int maximumSchoolDesk;
        int minimumSchoolDesk;

        if (schoolChildren % 2 == 0) {
            maximumSchoolDesk = schoolChildren;
            minimumSchoolDesk = schoolChildren / 2;
        } else {
            maximumSchoolDesk = schoolChildren;
            minimumSchoolDesk = schoolChildren / 2 + 1;
        }

        for (int i = 0; i < maximumSchoolDesk; i++) {
            int value = minimumSchoolDesk + i;
            if (value > maximumSchoolDesk) break;
            System.out.print(value + " ");
        }
    }
}
