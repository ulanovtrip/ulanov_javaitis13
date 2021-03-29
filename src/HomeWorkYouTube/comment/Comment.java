package HomeWorkYouTube.comment;

import HomeWorkYouTube.user.User;

public class Comment {
    private String text;
    private int likes;
    private int dislikes;
    User author;

    public Comment(String text, int likes, int dislikes, User author) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public User getAuthor() {
        return author;
    }
}
