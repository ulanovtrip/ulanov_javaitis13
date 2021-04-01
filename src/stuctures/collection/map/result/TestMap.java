package stuctures.collection.map.result;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Ivan", 27);
        hashMap.put("Isak", 7);
        hashMap.put("Nady", 25);
        hashMap.put("Victor", 24);
        hashMap.put("Victor", 28);
        hashMap.put("Aliya", 20);
        hashMap.put("Airat", 22);
        hashMap.put("Il'gam", 21);

        System.out.println(hashMap.get("Isak"));
        System.out.println(hashMap.get("Nady"));
        System.out.println(hashMap.get("Ivan"));
        System.out.println(hashMap.get("Ivano"));
        System.out.println(hashMap.get("Il'gam"));
        System.out.println(hashMap.get("Aliya"));
    }
}
