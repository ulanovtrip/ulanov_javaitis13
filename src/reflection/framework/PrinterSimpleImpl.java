package reflection.framework;

public class PrinterSimpleImpl implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
