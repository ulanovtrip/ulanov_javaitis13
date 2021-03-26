package stuctures.collection.map.hashes;

public class TestMain {
    public static void main(String[] args) {
        String text = "Hello!";
        String text2 = "Holle!";
        System.out.println(hashCodeInternal(text));
        System.out.println(hashCodeInternal(text2));

        // test hash from Human
        Human ivan = new Human("Ivan", 27, true, 182.0);
        Human nady = new Human("Nady", 25, true, 160.1);
        System.out.println(ivan.hashCode());
        System.out.println(nady.hashCode());
    }

    public static int hashCodeInternal(String text) {
        int hash = 0;
        char[] codes = text.toCharArray();

        for (int i = 0; i < codes.length; i++) {
            hash = 31 * hash + codes[i];
        }
        return hash;
    }
}
