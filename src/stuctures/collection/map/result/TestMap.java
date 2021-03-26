package stuctures.collection.map.result;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Ivan", 27);
        hashMap.put("Isak", 7);
        hashMap.put("Nady", 25);

        System.out.println(hashMap.get("Isak"));
        System.out.println(hashMap.get("Nady"));
        System.out.println(hashMap.get("Ivan"));
        System.out.println(hashMap.get("Ivano"));
    }
}
