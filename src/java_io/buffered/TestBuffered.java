package java_io.buffered;

import java.io.*;

public class TestBuffered {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("src/Java_IO/reader/reader1.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);


        Writer writer = new FileWriter("src/Java_IO/buffered/buff.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("Zigota Android");
        bufferedWriter.close();
    }
}
