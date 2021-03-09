package patterns.strategy.utils;

import java.io.File;
import java.io.IOException;

public class FileWriter {
    public void writeDataInFile(String encMessage, String path) {
        File file = new File(path);
        try {
            java.io.FileWriter writer = new java.io.FileWriter(file);
            writer.write(encMessage);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
