package HomeWork6;

public class UtilsForHW6 {

    public static boolean isEven(char element) {
        return Integer.valueOf(element) % 2 == 0;
    }

    public static int changeNumber(char element) {
        int current = Integer.valueOf(String.valueOf(element));
        int update = current - 1;
        return update;
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void print(Object object) {
        System.out.print(object);

    }
}
