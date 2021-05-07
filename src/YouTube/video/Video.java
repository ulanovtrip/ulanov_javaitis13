package YouTube.video;

import YouTube.comment.Comment;
import YouTube.user.User;

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

    public int getLength() {
        return length;
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

        // если лайки равны, то сравним по дислайкам.
        int dislikesCompareResult = this.dislikes.compareTo(o.dislikes);

        // чтобы показать, что много лайков это плохо, надо инвертировать
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
