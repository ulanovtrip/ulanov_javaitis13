package stuctures.collection.map.interesting.task6;

import java.util.ArrayList;
import java.util.List;

// Выясните, начинается ли List с 3 определённых элементов

public class Task6 {
    public static void main(String[] args) {

        List<String> fullList = new ArrayList<>(List.of("Pavel", "Alex", "Pavel", "Ivan", "Anna", "Evgeniy", "Anna"));

        List<String> listToCheck = new ArrayList<>(List.of("Pavel", "Alex"));

        Boolean result = isContainsInList(listToCheck, fullList);

        Boolean onlyFirstThree = isFirstThree(listToCheck, fullList);

        System.out.println(result);
        System.out.println(onlyFirstThree);
    }

    // проверить что у листа первые три именно эти элементы
    private static Boolean isFirstThree(List<String> listToCheck, List<String> fullList) {
        return fullList.subList(0, 2).containsAll(listToCheck);
    }

    // это проверит, что это лист просто содержит эти элементы
    private static Boolean isContainsInList(List<String> listToCheck, List<String> fullList) {
        return fullList.containsAll(listToCheck);
    }
}
