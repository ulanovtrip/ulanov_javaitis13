package stuctures.collection.map.interesting.task9;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// Найдите 100 минимальных значений из неотсортированного списка используя PriorityQueue
public class PriorityQueueTenMin {
    public static void main(String[] args) {

        int constant = 100000;

        List<Integer> integerList = new ArrayList<>();
        List<Integer> unsortedTwo = new ArrayList<>();

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < constant; i++) {
            integerList.add(random.nextInt(10000));
            unsortedTwo.add(random.nextInt(10000));
        }

        System.out.println("----------------------------------------------------------------------------");
        // вывод несортированного листа
        System.out.println(integerList.subList(0, 40));

        System.out.println("----------------------------------------------------------------------------");

        long startTime = System.nanoTime();
        // сортируем компаратором через лямбду
        integerList.sort((o1, o2) -> o1.compareTo(o2));
        // вывод сортированной части листа
        System.out.println(integerList.subList(0, 40));
        long endTime = System.nanoTime();
        System.out.println("subList: " + (endTime - startTime));


        System.out.println("----------------------------------------------------------------------------");

        // вывод (отфильтровать) первых N элементов через Stream API
        System.out.println(unsortedTwo.stream().limit(40).collect(Collectors.toList()));


        System.out.println("**************************************************************************************");

        // *** теперь сделаем тоже самое но с использованием PriorityQueue ***

        int countOfElem = 40; // колличество элементов, которые хотим полуить в итоге.

        long startTime2 = System.nanoTime();
        List<Integer> integerList3 = sortValuesByPriorityQueue(unsortedTwo, countOfElem);
        long endTime2 = System.nanoTime();
        System.out.println("PriorityQueue: " + (endTime2 - startTime2));

        // сортирует с помощью Stream API
        System.out.println(integerList3.stream().sorted().collect(Collectors.toList()));
    }


    // метод который находит 100 минимальных значений из неотсортированного списка используя PriorityQueue
    public static List<Integer> sortValuesByPriorityQueue(List<Integer> unsortedTwo, int countOfElem) {

/*
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                o1.compareTo(o2);

//                можно это же реализовать руками
//                if (o1 > o2) return 1;
//                if (o1 == o2) return 0;
//                if (o1 < o2) return -1;
    }
});
*/

        // Collections.reverseOrder() -
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // пройдёмся по листу
        for (Integer integer : unsortedTwo) {
            // если кол-во элементов в очереди меньше, чем кол-во, которое нужно вернуть, то
            if (priorityQueue.size() < countOfElem) {
                // добавляем наше текущее значение, пока не настанет необходимое кол-во элементов
                priorityQueue.add(integer);

                // если кол-во уже соответствует, а наверху лежит самый маленьких элемент в очереди
                // берём самый верхний элемент (первый кандидат на выход из очереди) очереди и смотрим его значение
                // поймём, он больше, чем то, что мы хотим сейчас добавить
            } else if (priorityQueue.peek().compareTo(integer) > 0) {
                // если элемент, который в очереди сейчас, больше чем тот, элемент, который мы хотим добавить
                // тогда убираем его из очереди методом poll()
                priorityQueue.poll();
                // после этого добавим тот элемент, который был меньше
                priorityQueue.add(integer);
            }
        }
        // т.к. любая коллекция принимает в себя другую коллекцию через конструктор
        // то можно добавить очередь в лист
        List<Integer> list = new ArrayList<>(priorityQueue);
        return list;
    }
}
