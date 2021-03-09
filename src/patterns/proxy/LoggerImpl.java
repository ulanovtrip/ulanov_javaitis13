package patterns.proxy;

import java.time.LocalDateTime;

public class LoggerImpl implements Logger {

    int counter = 0;

    @Override
    public String createLog() {
        counter++;
        return "Invoke №: " + counter + " " + LocalDateTime.now();
    }
}
