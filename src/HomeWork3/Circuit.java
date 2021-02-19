package HomeWork3;

import java.util.Scanner;

public class Circuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfRoad = scanner.nextInt();
        int speedOfFirst = scanner.nextInt();
        int speedOfSecond = scanner.nextInt();
        int time = scanner.nextInt();

        // нашли пройденные расстояния объектов
        int pathFirst = speedOfFirst * time;
        int pathSecond = speedOfSecond * time;

        // найти смещение относительно старта
        int offsetFirst = pathFirst % lengthOfRoad;
        int offsetSecond = pathSecond % lengthOfRoad;

        if (pathFirst + pathSecond == lengthOfRoad) {
            System.out.println(0);
            return;
        }

        int firstMinLengthToStart = Math.min(offsetFirst, lengthOfRoad - offsetFirst);
        int secondMinLengthToStart = Math.min(offsetSecond, lengthOfRoad - offsetSecond);

        int sumOfMin = Math.abs(firstMinLengthToStart + secondMinLengthToStart);

        int result = Math.min(sumOfMin, lengthOfRoad - (sumOfMin));
        System.out.println(result);
    }
}
