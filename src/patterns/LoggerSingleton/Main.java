package patterns.LoggerSingleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        SimpleMath simpleMath = new SimpleMath(logger);
        SimpleScannerReader reader = new SimpleScannerReader(logger);

        int result = simpleMath.div(reader.getNumber(), reader.getNumber());
        System.out.println(result);
    }
}
