package generics.itis.part1.collections;

public class TestArrayGeneric {
    public static void main(String[] args) {
        ArrayListGeneric<String> strings = new ArrayListGeneric<>();
        strings.add("Ivan");
        strings.add("how are you doing?");

        String out = strings.get(1);
        System.out.println(out);

        ArrayListGeneric<Integer> integers = new ArrayListGeneric<>();
        integers.add(101);
        integers.add(202);
        System.out.println(integers.get(1));

        // после параметризации интерфейсов можно писать так
        List<Character> characterList = new ArrayListGeneric<>();
        characterList.add('U');
        characterList.add('N');
        System.out.println(characterList.get(1));
    }
}
