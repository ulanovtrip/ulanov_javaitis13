package stuctures.collection.map.simple;

public class TestMain {
    public static void main(String[] args) {
        ArrayIntegerKeyMapImpl array = new ArrayIntegerKeyMapImpl();
        array.put(1, 7);
        array.put(2, 5);
        System.out.println(array.get(2));
        System.out.println(array.get(1));

        ArrayIntegerKeyMapImpl<String> example2 = new ArrayIntegerKeyMapImpl<>();
        example2.put(0, "Ivan");
        example2.put(1, "are you Okay?");
        System.out.println(example2.get(1) + " " + example2.get(0));
    }
}
