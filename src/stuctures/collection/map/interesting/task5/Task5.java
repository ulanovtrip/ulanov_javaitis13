package stuctures.collection.map.interesting.task5;

//Реализовать метод, который принимает на вход середину листа, считает частотный словарь символов

import stuctures.collection.map.interesting.task1.FrequencyMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {

        // можно добавить лист в конструктор коллекции, чтобы сделат его изменяемым
        List<String> myList = new ArrayList<>(List.of("Pavel", "Alex", "Pavel", "Ivan", "Anna", "Evgeniy", "Anna"));

        //List<String> middle = getMiddleOfAnotherList(myList);
        List<String> middle = myList.subList(2, 5);
        System.out.println(middle);

        // сохранил середину
        List<String> savedMiddle = new ArrayList<>(middle);

        //Напишите метод, удаляющий эту середину листа, clear() удаляет subList
        middle.clear();
        System.out.println(myList);


        // посчитаем частоту символов в списке из середины
        Map<Character, Integer> frequencyMap = getFrequencyForList(savedMiddle);
        System.out.println(frequencyMap);

    }

    // метод, который принимает на вход середину листа, считает частотный словарь символов
    private static Map<Character, Integer> getFrequencyForList(List<String> stringList) {

        // Нужен будет указатель
        Integer pointer = null;

        // здесь нужно обединить мапы
        Map<Character, Integer> resultMap = new HashMap<>();

        for (String str : stringList) {
            Map<Character, Integer> currentMap = FrequencyMap.getFrequencyOfTextCharacters(str);
            // дальше нужно выполнить слияние двух мап
            // сначала пройдёмся по всему списку пар из мапы
            /*
            Entry внутренний interface, хранит пару (ключ+значение представленны в виде этого класса),
            у каждый мапы своя реализация
             */
            for (Map.Entry<Character, Integer> keyValuePair : currentMap.entrySet()) {
                // если Integer (pointer), который мы достанем из результирующей мапы не равен нулю,
                // значит уже встретилось и есть в результируещей мапе
                Character key = keyValuePair.getKey();
                if ((pointer = resultMap.get(key)) != null) {
                    // тогда увеличим значение ключа в результирующей мапе по тому же значению
                    resultMap.put(key, pointer + keyValuePair.getValue());
                } else {
                    resultMap.put(key, keyValuePair.getValue());
                }
            }
        }
        return resultMap;
    }

    // так можно вручную вытащить середину, но есть subList()
    private static List<String> getMiddleOfAnotherList(List<String> myList) {
        List<String> result = new ArrayList<>();

        for (int i = 2; i <= 4; i++) {
            result.add(myList.get(i));
        }
        return result;
    }
}
