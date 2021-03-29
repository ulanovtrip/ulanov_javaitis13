package HomeWorkYouTube.user;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.video.Video;

import java.util.List;
import java.util.StringJoiner;

public class User implements Comparable<User> {
    private List<Video> videoList;
    private String firstName;
    private String lastName;
    private int countOfMoney;
    List<Comment> comments;

    public User(String firstName, String lastName, int countOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countOfMoney = countOfMoney;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCountOfMoney() {
        return countOfMoney;
    }

    public List<Comment> getComments() {
        return comments;
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
                .toString();
    }

    @Override
    public int compareTo(User o) {
        // TODO
        return 0;
    }
}
