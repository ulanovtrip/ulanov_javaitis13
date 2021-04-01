package HomeWorkYouTube.user;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.video.Video;

import java.util.List;
import java.util.StringJoiner;

public class User implements Comparable<User> {
    private List<Video> videoList;
    private String firstName;
    private String lastName;
    private Integer countOfMoney;
    List<Comment> comments;

    public User(String firstName, String lastName, Integer countOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countOfMoney = countOfMoney;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("Money=" + countOfMoney + "'")
                .toString();
    }

    @Override
    public int compareTo(User o) {

        int result = this.countOfMoney.compareTo(o.countOfMoney);

        if (result != 0) {
            return result;
        } else {
            return 0;
        }
    }
}
