package stuctures.collection.map.interesting.task3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskThree {
    public static void main(String[] args) {
        testTimeOfDifferentListImpl();
    }

    private static void testTimeOfDifferentListImpl() {
        List<Integer> integersArrayList = new ArrayList<>();
        List<Integer> integersLinkedList = new LinkedList<>();

        SecureRandom secureRandom = new SecureRandom();

        int size = 1000000;
        int attemptCount = 1000000;

        for (int i = 0; i < size; i++) {
            integersArrayList.add(secureRandom.nextInt(size));
            integersLinkedList.add(secureRandom.nextInt(size));
        }

        long timeStart = System.nanoTime();
        for (int i = 0; i < attemptCount; i++) {
            integersArrayList.get((int) Math.random() * (size - 1));
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList " + (endTime - timeStart));

        System.out.println("---------------------------------------------");

        timeStart = System.nanoTime();
        for (int i = 0; i < attemptCount; i++) {
            integersLinkedList.get((int) Math.random() * (size - 1));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList " + (endTime - timeStart));
    }
}
