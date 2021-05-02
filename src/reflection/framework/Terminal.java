package reflection.framework;

import java.security.SecureRandom;

public class Terminal {

    private Printer printer;
    SecureRandom random = new SecureRandom();

    public void giveMoney() {
        printer.print("Выдана сумма: " + random.nextInt(1000));
    }
}
