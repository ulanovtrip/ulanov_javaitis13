package reflection.framework;

import java.time.LocalDateTime;

public class PrinterExtendedImpl implements Printer {
    @Override
    public void print(String message) {
        System.err.println(LocalDateTime.now() + " " + message);
    }
}
