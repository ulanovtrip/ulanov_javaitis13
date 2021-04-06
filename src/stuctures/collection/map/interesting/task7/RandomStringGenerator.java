package stuctures.collection.map.interesting.task7;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomStringGenerator {
    public static void main(String[] args) {
        //реализовать метод, который наполняет List рандомными строками без subList и с ним
        List<String> randomList = new ArrayList<>(47);
        List<String> filledList = (List<String>) fillListRandomStrings(randomList, 10);
        System.out.println(filledList);
    }

    public static List<?> fillListRandomStrings(List<String> list, int lengthOfString) {
        for (int i = 0; i < lengthOfString; i++) {
            list.add(generateRandomString(lengthOfString));
        }
        return list;
    }

    public static String generateRandomString(int lengthOfString) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < lengthOfString; i++) {
            // generate random index of letter from Alphabet
            int index = secureRandom.nextInt(AlphaNumericString.length());
            stringBuilder.append(AlphaNumericString.charAt(index));
        }

        return stringBuilder.toString();
    }
}
