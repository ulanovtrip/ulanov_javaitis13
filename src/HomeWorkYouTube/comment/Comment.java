package HomeWorkYouTube.comment;

import HomeWorkYouTube.user.User;

import java.util.StringJoiner;

public class Comment implements Comparable<Comment> {
    private String text;
    private Integer likes;
    private Integer dislikes;
    User author;

    public Comment(String text, int likes, int dislikes, User author) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        this.author = author;
    }

    public int getDislikes() {
        return dislikes;
    }

    @Override
    public int compareTo(Comment o) {
        int result = this.dislikes.compareTo(o.dislikes);
        if (result != 0) {
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Comment.class.getSimpleName() + "[", "]")
                .add("dislikes=" + dislikes)
                .add("author=" + author)
                .toString();
    }
}
