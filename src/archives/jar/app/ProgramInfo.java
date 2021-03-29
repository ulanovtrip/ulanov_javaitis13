package archives.jar.app;

import archives.jar.utils.FileInformation;

public class ProgramInfo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("--------------------------------");
        for (String path : args) {
            FileInformation information = new FileInformation(path);
            Thread thread = new Thread(information);
            thread.start();
            thread.join();
        }
    }
}
