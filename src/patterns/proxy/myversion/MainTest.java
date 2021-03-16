package patterns.proxy.myversion;

public class MainTest {
    public static void main(String[] args) {
        Logger loggerImpl = new LoggerImpl();
        LoggerProxy loggerProxy = new LoggerProxy(loggerImpl, "src/patterns/proxy/myversion/log.txt");
        loggerProxy.createLog();
        loggerProxy.createLog();
        loggerProxy.createLog();
        loggerProxy.createLog();
        loggerProxy.createLog();
    }
}
