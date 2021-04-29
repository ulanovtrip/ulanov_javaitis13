package java_io.input.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // абстрактный класс
        InputStream inputStream;

        // конкретная реализация InputStream
        inputStream = new FileInputStream("src/Java_IO/input.txt");
        // считаем байт
        int byteFromFile = inputStream.read();
        System.out.println(byteFromFile);

        // печать байта как символа
        char character = (char) byteFromFile;
        System.out.println(character);

        byteFromFile = inputStream.read();

        // считаем русскую букву
        System.out.println("-----------------------------------------");
        InputStream inputStreamRus = new FileInputStream("src/Java_IO/rusland.txt");

        // первый байт
        int rusByte = inputStreamRus.read();
        System.out.println(rusByte);
        // второй
        rusByte = inputStreamRus.read();
        System.out.println(rusByte);
        // т.к. третьего нет, то вернётся -1
        rusByte = inputStreamRus.read();
        System.out.println(rusByte);



    }
}
