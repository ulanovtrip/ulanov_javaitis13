package LoggerSingleton;

public class SimpleMath {
    private Logger logger;

    public SimpleMath(Logger logger) {
        this.logger = logger;
    }

    public int div(int a, int b) {
        if (b == 0) {
            logger.error("Division by zero!");
            return -1;
        } else {
            logger.info("Operation complete!");
            return a / b;
        }
    }
}
