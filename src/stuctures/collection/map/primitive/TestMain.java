package stuctures.collection.map.primitive;

public class TestMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new PrimitiveMapImpl<>();
        map.put("Ivan", 36);
        map.put("Ivan", 37);
        map.put("Nady", 34);
        map.put("Isak", 5);

        System.out.println(map.get("Isak"));
        System.out.println(map.get("Ivan"));
        System.out.println(map.get("Nady"));
        System.out.println(map.get("Gady"));
    }
}
