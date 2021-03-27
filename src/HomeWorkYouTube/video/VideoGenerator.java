package HomeWorkYouTube.video;

import HomeWorkYouTube.user.User;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoGenerator {

    List<Video> videos = new ArrayList<>();
    File namesOfVideo = new File("src/HomeWorkYouTube/video/name-of-videos.txt");
    Scanner scannerName;
    SecureRandom random = new SecureRandom();

    public List<Video> generateVideos(List<User> users) {
        try {
            scannerName = new Scanner(namesOfVideo);
            while (scannerName.hasNext()) {
                int likes = random.nextInt(100000);
                int dislikes = random.nextInt(100000);
                int length = random.nextInt(180);
                String name = scannerName.nextLine();
                int index = Math.abs(random.nextInt(users.size()));
                User author = users.get(index);
                videos.add(new Video(name, likes, dislikes, length, author));
            }
        } catch (IOException e) {
            System.out.println("file not exist...");
        }
        return videos;
    }
}
