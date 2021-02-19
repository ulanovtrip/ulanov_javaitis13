package HomeWork3;

/*
111
112
113
114
* */
public class TrokoBochki {
    public static void main(String[] args) {

        for (int i = 0; i < 301; i++) {
            giveWord(i);
        }

    }

    public static void giveWord(int n) {
        if (n <= 1000 && n > 20) {
            if (n % 10 == 1) {
                System.out.println(n + " bochka");
            } else if (n % 10 == 2 || n % 10 == 3 || n % 10 == 4) {
                System.out.println(n + " bochki");
            } else
                System.out.println(n + " bochek");

        } else {
            if (n == 1) {
                System.out.println(n + " bochka");
            } else if (n == 2 || n == 3 || n == 4) {
                System.out.println(n + " bochki");
            } else
                System.out.println(n + " bochek");
        }
    }
}
