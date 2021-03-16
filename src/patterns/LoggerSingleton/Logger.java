package patterns.LoggerSingleton;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Logger {
    // единственное глобальное поле для всех компонентов, которое хранит экземляр класса
    private static Logger instance;

    // неленивая инициализация
    static {
        instance = new Logger();
    }

    private LocalDateTime creationTime;
    private String loggerName;

    private Logger() {
        this.creationTime = LocalDateTime.now();
        this.loggerName = "LOGGER: " + creationTime.toString();
    }

    public void info(String message) {
        System.out.println(loggerName + " INFO [ " + LocalTime.now() + "] " + message);
    }

    public void error(String error) {
        System.err.println(loggerName + " ERROR [ " + LocalTime.now() + "] " + error);
    }

    // фабричный метод
    public static Logger getInstance() {
        // для ленивой инициализации
        /*
        //  if (instance == null) {
//            return instance = new Logger();
//        } else {
//            return instance;
//        }
         */
        return instance;
    }
}
