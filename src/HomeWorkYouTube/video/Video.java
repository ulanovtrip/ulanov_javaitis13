package HomeWorkYouTube.video;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.user.User;

import java.util.List;
import java.util.StringJoiner;

public class Video implements Comparable<Video> {

    private String name;
    private Integer likes;
    private Integer dislikes;
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

    public String getName() {
        return name;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public int getLength() {
        return length;
    }

    public User getAuthor() {
        return author;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int compareTo(Video o) {
        int result = this.likes.compareTo(o.likes);

        if (result != 0) {
            return result;
        }

        int dislikesCompareResult = this.dislikes.compareTo(o.dislikes);

        switch (dislikesCompareResult) {
            case -1:
                return 1;
            case 1:
                return -1;
            default:
                return dislikesCompareResult;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Video.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("likes=" + likes)
                .add("dislikes=" + dislikes)
                .add("length=" + length)
                .add("author=" + author)
                .toString();
    }
}
