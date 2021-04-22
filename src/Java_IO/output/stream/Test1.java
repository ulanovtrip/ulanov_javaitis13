package Java_IO.output.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test1 {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("src/Java_IO/output/stream/out1.txt", true);
        outputStream.write("Hello".getBytes());
        outputStream.write(" Ivan\n".getBytes());
        outputStream.close();
    }
}
