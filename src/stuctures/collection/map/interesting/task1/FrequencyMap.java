package stuctures.collection.map.interesting.task1;

import java.util.HashMap;
import java.util.Map;

public class FrequencyMap {
    public static void main(String[] args) {
        String randomText = "Задача организации, в особенности же начало повседневной работы" +
                " по формированию позиции позволяет выполнить важнейшие задания по разработке модели развития! " +
                "Практический опыт показывает, что социально-экономическое развитие создаёт предпосылки качественно " +
                "новых шагов для системы масштабного изменения ряда параметров?" +
                " Равным образом постоянное информационно-техническое обеспечение " +
                "нашей деятельности представляет собой интересный эксперимент проверки " +
                "системы масштабного изменения ряда параметров.";

        Map<Character, Integer> frequencyMap = getFrequencyOfTextCharacters(randomText);
        System.out.println(frequencyMap);
    }

    public static Map<Character, Integer> getFrequencyOfTextCharacters(String randomText) {

        Integer pointer;

        randomText = randomText.toLowerCase();

        // мапа для промежуточного хранения данных
        Map<Character, Integer> resultMap = new HashMap<>();

        // пройдёмся по всем символам в рамках строки
        for (int i = 0; i < randomText.length(); i++) {
            // берём по порядку символы, character - это ключ для resultMap
            Character character = randomText.charAt(i);
            // сначала проверим, есть ли что-то под этим ключом уже
            // для этого достанем значение по ключу и сохраним в pointer
            pointer = resultMap.get(character);

            if (pointer != null) {
                // тогда увеличим значение встречаемости символа на 1
                resultMap.put(character, ++pointer);
            } else {
                // но если в мапе на этой позиции пусто, то кладём этот символ на это место
                // и ставим число повторений равное 1
                resultMap.put(character, 1);
            }
        }
        return resultMap;
    }
}
