package HomeWork6;

public class NumbersAndStringsProcessor {

    String[] stringProcess;
    int[] numbersProcess;

    public NumbersAndStringsProcessor(String[] stringProcess) {
        this.stringProcess = stringProcess;
    }

    public NumbersAndStringsProcessor(int[] numbersProcess) {
        this.numbersProcess = numbersProcess;
    }

    public int[] process(NumbersProcess process) {
        for (int i = 0; i < numbersProcess.length; i++) {
            numbersProcess[i] = process.process(numbersProcess[i]);
        }
        return numbersProcess;
    }

    public String[] process2(StringProcess process) {
        String[] changed = new String[stringProcess.length];
        for (int i = 0; i < stringProcess.length; i++) {
            changed[i] = process.process(stringProcess[i]);
        }
        return changed;
    }
}
