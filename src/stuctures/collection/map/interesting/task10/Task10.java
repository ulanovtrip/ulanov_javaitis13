package stuctures.collection.map.interesting.task10;

//Проверить наличие повторяющихся элементов в списке используя Set,
// не используя метода contains, equals, и итератор по списку

import stuctures.collection.map.interesting.task2.UniqueExemplars;

import java.security.SecureRandom;
import java.util.*;

import static stuctures.collection.map.interesting.task9.PriorityQueueTenMin.sortValuesByPriorityQueue;

public class Task10 {
    public static void main(String[] args) {

        int constant = 100000;

        List<Integer> usortedList = new ArrayList<>();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < constant; i++) {
            usortedList.add(random.nextInt(10000));
        }

        int countOfElem = 40; // колличество элементов, которые хотим полуить в итоге.

        List<Integer> integerList3 = sortValuesByPriorityQueue(usortedList, countOfElem);

        Map<Integer, Integer> keyCounterMap = new HashMap<>();
        List<Integer> integerListWithUniqueValues = new ArrayList<>();

        // сравним длинны листов до и после удаления дубликатов если false, то дубликаты есть.
        System.out.println(UniqueExemplars.clearCollectionFromDuplicatesElements(integerList3).size() != integerList3.size());

        // теперь надо выяснить какие это дубликаты
        /*
        любые действия с листом можно задавать с помощью лямбды foreach
         */

        // ниже конструкция подсчитает колличество элементов которые повторяются и какие это элементы
        // Это плохой пример!!!
        integerList3.forEach((value) -> {
            if (!integerListWithUniqueValues.contains(value)) {
                integerListWithUniqueValues.add(value);
                keyCounterMap.put(value, 1);
            } else {
                Integer integer = keyCounterMap.get(value);
                keyCounterMap.put(value, ++integer);
            }
        });
        System.out.println(keyCounterMap);

        System.out.println("---------------------------------------------------------------------");

        // Рассмотрим теперь хороший пример этой же задачи
        List<Integer> resultListForSet = sortValuesByPriorityQueue(usortedList, countOfElem);
        Set<Integer> resultSet = new HashSet<>();
        Map<Integer, Integer> keyCounterMapFromSet = new HashMap<>();

        resultListForSet.forEach((value) -> {
            // add вернёт true, если элемент был добавлен в множество
            if (resultSet.add(value)) {
                keyCounterMapFromSet.put(value, 1);
            } else {
                Integer integer = keyCounterMapFromSet.get(value);
                keyCounterMapFromSet.put(value, ++integer);
            }
        });

        System.out.println(resultSet);
    }
}
