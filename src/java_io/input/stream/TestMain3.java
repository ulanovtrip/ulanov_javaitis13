package java_io.input.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestMain3 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream;
        inputStream = new FileInputStream("src/Java_IO/intput3.txt");

        byte[] bytes = new byte[100];

        int length = inputStream.read(bytes);

        System.out.println(new String(bytes));
        System.out.println(length);
    }
}
