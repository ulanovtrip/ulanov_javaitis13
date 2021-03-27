package HomeWorkYouTube.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserGenerator {

    List<User> users = new ArrayList<>();
    File file = new File("src/HomeWorkYouTube/user/names.txt");
    Scanner scanner;

    public List<User> generateUsers() {

        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String firstName = scanner.next();
                String lastName = scanner.next();
                users.add(new User(firstName, lastName));
            }
        } catch (IOException e) {
            System.out.println("file not exist...");
        }
        return users;
    }
}
