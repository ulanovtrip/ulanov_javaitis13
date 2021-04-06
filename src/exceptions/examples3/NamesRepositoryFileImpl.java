package exceptions.examples3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NamesRepositoryFileImpl {

    private File file;

    public NamesRepositoryFileImpl(String file) {
        this.file = new File(file);
    }

    public List<String> findNames() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> lines = new ArrayList<>();
        String line = bufferedReader.readLine();

        while (line != null) {
            lines.add(line);
            line = bufferedReader.readLine();
        }
        return lines;
    }
}
