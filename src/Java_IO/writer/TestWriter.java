package Java_IO.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter {
    public static void main(String[] args) throws IOException {
        Writer writer;
        writer = new FileWriter("src/Java_IO/writer/out.txt");
        writer.write("Simple Строка!");
        // нужно всегда закрываь поток
        writer.close();
    }
}
