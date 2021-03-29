package HomeWorkYouTube.comment;

import HomeWorkYouTube.user.User;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommentGenerator {

    List<Comment> comments = new ArrayList<>();
    File file = new File("src/HomeWorkYouTube/comment/comments.txt");
    Scanner scanner;
    SecureRandom random = new SecureRandom();

    public List<Comment> generateComments(List<User> users) {

        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {

                int userIndex = Math.abs(random.nextInt(users.size()));

                comments.add(new Comment(
                                scanner.nextLine(),
                                Math.abs(random.nextInt(500)),
                                Math.abs(random.nextInt(500)),
                                users.get(userIndex)
                        )
                );
            }

        } catch (IOException e) {
            System.out.println("file not exist...");
        }
        return comments;
    }
}
