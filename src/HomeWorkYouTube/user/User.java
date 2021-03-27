package HomeWorkYouTube.user;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.video.Video;

import java.util.List;

public class User {
    private List<Video> videoList;
    private String firstName;
    private String lastName;
    private int countOfMoney;
    List<Comment> commentList;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
