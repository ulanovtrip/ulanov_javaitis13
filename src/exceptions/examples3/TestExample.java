package exceptions.examples3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestExample {
    public static void main(String[] args) {
        String path = "src/exceptions/examples3/input.txt";
        NamesRepositoryFileImpl repositoryFile = new NamesRepositoryFileImpl(path);

        List<String> names = null;

        try {
            names = repositoryFile.findNames();
        } catch (FileNotFoundException e) {
            System.out.println("Shit happens file not found" + e.getStackTrace());
        } catch (IOException e) {
            System.out.println("IO problems :" + e.getStackTrace());
        }

        System.out.println(names);
    }
}
