package generics.itis.part2.generic_method;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        Converter converter = new Converter();
        List<String> words = Arrays.asList("Ivan", "How", "are", "you");
        List<Boolean> result = converter.convert(words, element -> {
            if (Character.isUpperCase(element.charAt(0))) {
                return true;
            }
            return false;
        });

        System.out.println(result);
    }
}
