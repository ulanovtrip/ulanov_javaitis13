package stuctures.collection.map.interesting.task12;

//  Развернуть Map (поменять местами ключ и значение)

import stuctures.collection.map.interesting.task7.RandomStringGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseMap {
    public static void main(String[] args) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        List<String> randomStrings = new ArrayList<>();
        RandomStringGenerator.fillListRandomStrings(randomStrings, 13);

        Map<String, String> randomMap = new HashMap<>();

        for (int i = 0; i < randomStrings.size(); i++) {
            randomMap.put(String.valueOf(alphaNumericString.charAt(i)), randomStrings.get(i));
        }


        // теперь надо поменять все ключи и значения местами
        Map<String, String> swappedMap = new HashMap<>(); // временная мапа для разворота
        for (Map.Entry<String, String> tempMap : randomMap.entrySet()) {
            String key = tempMap.getKey();
            String value = tempMap.getValue();
            swappedMap.put(value, key);
        }

        System.out.println(swappedMap);

        //У полученной map поменять местами значения у двух разных ключей
        swapConcreteKeyInMap("A", "C", randomMap);
    }

    public static void swapConcreteKeyInMap(String key1, String key2, Map<String, String> map) {
        String valueOfKey1 = map.get(key1);
        String valueOfKey2 = map.get(key2);
        map.put(key1, valueOfKey2);
        map.put(key2, valueOfKey1);
    }
}
