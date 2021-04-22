package Java_IO.reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestReader {
    public static void main(String[] args) throws IOException {

        // ридер позволяет работать с текстовой информацией, он считывает символы
        Reader reader = new FileReader("src/Java_IO/reader/reader1.txt");
        int code = reader.read();
        System.out.println("First symbol code: " + code);

        // напечатает в консоль строку из файла
        while (code != -1) {
            // каст int в символы
            System.out.print((char) code);
            code = reader.read();
        }
    }
}
