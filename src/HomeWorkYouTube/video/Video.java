package HomeWorkYouTube.video;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.user.User;

import java.util.List;

public class Video {
    private String name;
    private int likes;
    private int dislikes;
    List<Comment> commentList;
    private int length;
    User author;

    public Video(String name, int likes, int dislikes, int length, User author) {
        this.name = name;
        this.likes = likes;
        this.dislikes = dislikes;
        this.length = length;
        this.author = author;
    }
}
