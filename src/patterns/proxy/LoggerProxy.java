package patterns.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Логирование запросов (логирующий прокси). Когда требуется хранить историю обращений к сервисному объекту.
 */

public class LoggerProxy implements Logger {

    private String messageForLog;
    private final Logger logger;
    private final File logFile;

    LoggerProxy(Logger logger, String pathToFile) {
        this.logger = logger;
        this.logFile = new File(pathToFile);
    }

    @Override
    public String createLog() {
        messageForLog = logger.createLog();
        checkAccessToFile();
        writeInFile();
        return messageForLog;
    }

    private void writeInFile() {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(messageForLog + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkAccessToFile() {
        if (logFile.exists()) {
            System.out.println("File is exist!");
        } else {
            System.err.println("File doesn't exist!");
        }
    }
}
