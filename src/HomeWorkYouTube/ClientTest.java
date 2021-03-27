package HomeWorkYouTube;

import HomeWorkYouTube.user.User;
import HomeWorkYouTube.user.UserGenerator;
import HomeWorkYouTube.video.Video;
import HomeWorkYouTube.video.VideoGenerator;

import java.util.List;

public class ClientTest {
    public static void main(String[] args) {
        UserGenerator userGenerator = new UserGenerator();
        List<User> users = userGenerator.generateUsers();

        VideoGenerator videoGenerator = new VideoGenerator();
        List<Video> videoList = videoGenerator.generateVideos(users);
    }
}
