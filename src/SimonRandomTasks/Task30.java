package SimonRandomTasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task30 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/test/in.txt");

        Scanner scanner = new Scanner(file);

        FileWriter fileWriter = new FileWriter("src/test/out.txt");

        while (scanner.hasNext()) {
            fileWriter.write(scanner.nextLine() + "\n");
        }

        fileWriter.flush();
    }
}
