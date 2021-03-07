package HomeWork6;

import static HomeWork6.UtilsForHW6.print;
import static HomeWork6.UtilsForHW6.println;

public class NumbersAndStringsProcessor {

    String[] stringProcess;
    int[] numbersProcess;

    public NumbersAndStringsProcessor(String[] stringProcess) {
        this.stringProcess = stringProcess;
    }

    public NumbersAndStringsProcessor(int[] numbersProcess) {
        this.numbersProcess = numbersProcess;
    }

    public void multiplyAllElements(NumbersProcess process) {
        print("Before: ");
        for (int j : numbersProcess) {
            print(j + " ");
        }
        println("");
        print("After: ");
        for (int i = 0; i < numbersProcess.length; i++) {
            numbersProcess[i] = process.process(numbersProcess[i]);
            print(numbersProcess[i] + " ");
        }
    }

    public void makeAllUpperCase(StringProcess process) {
        print("Before: ");
        for (String s : stringProcess) {
            print(s + " ");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringProcess) {
            stringBuilder.append(process.process(s));
        }
        println("");
        print("After: " + stringBuilder.toString());
    }
}
