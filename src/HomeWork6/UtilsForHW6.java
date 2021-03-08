package HomeWork6;

public class UtilsForHW6 {

    public static int revers(int num) {
        int reversed = 0;
        while (num != 0) {
            int remainder = num % 10;
            num /= 10;
            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void print(Object object) {
        System.out.print(object);

    }
}
