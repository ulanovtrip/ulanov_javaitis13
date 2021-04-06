package exceptions.bestpractise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NamesRepositoryFileImpl {

    private File file;

    public NamesRepositoryFileImpl(String file) {
        this.file = new File(file);
    }

    public List<String> findNames() {
        FileReader fileReader;

        // обаботка на месте
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            // выброс непроверяемого, оно остановит программу
            throw new IllegalArgumentException(e);
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> lines = new ArrayList<>();
        String line;

        // обаботка на месте
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            // выброс непроверяемого, оно остановит программу
            throw new IllegalStateException(e);
        }

        while (line != null) {
            lines.add(line);

            // обаботка на месте
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                // выброс непроверяемого, оно остановит программу
                throw new IllegalStateException(e);
            }
        }
        return lines;
    }
}
