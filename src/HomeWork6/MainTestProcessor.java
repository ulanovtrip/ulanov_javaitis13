package HomeWork6;

import static HomeWork6.UtilsForHW6.println;

public class MainTestProcessor {
    public static void main(String[] args) {
        int[] integerArray = {2, 3, 4, 5, 6, 7};
        String[] stringArray = {"q", "fg", "safa", "jojrfr"};

        NumbersAndStringsProcessor processor1 = new NumbersAndStringsProcessor(integerArray);
        NumbersAndStringsProcessor processor2 = new NumbersAndStringsProcessor(stringArray);

        processor1.multiplyAllElements(number -> number * 2);
        println("");
        println("+++++++++++++++++++++++++++++++");

        //  :: - method reference operator, is used to call a method by referring to it with the help of its class directly.
        processor2.makeAllUpperCase(String::toUpperCase);
    }
}
