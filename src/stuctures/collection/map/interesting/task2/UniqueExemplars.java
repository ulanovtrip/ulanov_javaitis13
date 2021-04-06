package stuctures.collection.map.interesting.task2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class UniqueExemplars {
    public static void main(String[] args) {

        List<String> listToClear = List.of("Pavel", "Alex", "Pavel", "Ivan", "Anna", "Evgeniy", "Anna");

        Collection<String> clearedCollection = (Collection<String>) clearCollectionFromDuplicatesElements(listToClear);
        System.out.println(clearedCollection);
    }

    public static Collection<?> clearCollectionFromDuplicatesElements(Collection<?> listToClear) {
        return new HashSet<>(listToClear);
    }
}
