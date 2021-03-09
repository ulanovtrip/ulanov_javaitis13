package patterns.strategy.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    private String operation;
    private int key;
    private String message;
    private String pathToReadFile;
    private String pathToWriteFile;
    private String typeOfAlgorithm;

    public void parsInput(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-mode")) {
                operation = args[i + 1];
            }
            if (args[i].equals("-key")) {
                if (args[i].matches("\\d+")) {
                    key = 0;
                } else {
                    key = Integer.parseInt(args[i + 1]);
                }
            }
            if (args[i].equals("-data")) {
                if (args[i].matches("\\W+")) {
                    message = "";
                } else {
                    message = args[i + 1];
                }
            }
            if (args[i].equals("-in")) {
                pathToReadFile = args[i + 1];
                message = readDataFromFile(pathToReadFile);
            }

            if (args[i].equals("-out")) {
                pathToWriteFile = args[i + 1];
            }

            if (args[i].equals("-alg")) {
                typeOfAlgorithm = args[i + 1];
            }
        }
    }

    public String readDataFromFile(String path) {
        StringBuilder out = new StringBuilder();
        try {
            out.append(new String(Files.readAllBytes(Paths.get(path))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public String getOperation() {
        return operation;
    }

    public int getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public String getPathToReadFile() {
        return pathToReadFile;
    }

    public String getPathToWriteFile() {
        return pathToWriteFile;
    }

    public String getTypeOfAlgorithm() {
        return typeOfAlgorithm;
    }
}
