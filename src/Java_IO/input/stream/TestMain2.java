package Java_IO.input.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TestMain2 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream;
        inputStream = new FileInputStream("src/Java_IO/hello.txt");

        int[] bytes = new int[20];

        int currentByte = inputStream.read();
        int i = 0;

        while (currentByte != -1) {
            bytes[i] = currentByte;
            // читаем следующий байт
            currentByte = inputStream.read();
            i++;
        }

        // получим коды символов
        System.out.println(Arrays.toString(bytes));

        System.out.println("-------------------------------------------------------------");
        byte[] realBytes = new byte[i];
        // конвертирование int в byte
        for (int j = 0; j < realBytes.length; j++) {
            realBytes[j] = (byte) bytes[j];
        }

        // конвертирование байтов в строку
        String value = new String(realBytes);
        System.out.println(value);
    }
}
