package printers;

public class PrinterErrorImpl implements Printer {

    @Override
    public void print(String message) {
        System.err.println(message);
    }
}
