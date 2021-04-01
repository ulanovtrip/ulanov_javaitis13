package HomeWorkYouTube.statistic;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.user.User;
import HomeWorkYouTube.video.Video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    public List<Video> showBestRatingVideo(List<Video> videos) {
        Collections.sort(videos, Collections.reverseOrder());
        return videos;
    }

    public List<User> showReachUsers(List<User> mostReachUsers) {
        Collections.sort(mostReachUsers);
        return mostReachUsers;
    }

    public List<Comment> showMostDislikeComments(List<User> mostReachUsers) {

        List<Comment> dislikedComments = new ArrayList<>();

        Collections.sort(mostReachUsers, Collections.reverseOrder());

        return dislikedComments;
    }
}
