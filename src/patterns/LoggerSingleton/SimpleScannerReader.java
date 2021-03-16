package patterns.LoggerSingleton;

import java.util.Scanner;

public class SimpleScannerReader {
    private Logger logger;
    private Scanner scanner;

    public SimpleScannerReader(Logger logger) {
        this.logger = logger;
        this.scanner = new Scanner(System.in);
    }

    public int getNumber() {
        int num = scanner.nextInt();
        logger.info("Got the Number!");
        return num;
    }
}
