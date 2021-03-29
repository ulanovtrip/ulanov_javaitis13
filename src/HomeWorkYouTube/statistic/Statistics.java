package HomeWorkYouTube.statistic;

import HomeWorkYouTube.user.User;
import HomeWorkYouTube.video.Video;

import java.util.Collections;
import java.util.List;

public class Statistics {

    public List<Video> showBestRatingVideo(List<Video> videos) {
        Collections.sort(videos, Collections.reverseOrder());
        return videos;
    }

    public List<User> showReachUsers(List<User> mostReachUsers) {
        Collections.sort(mostReachUsers, Collections.reverseOrder());
        return mostReachUsers;
    }

    public List<User> showMostDislikeComments(List<User> mostReachUsers) {
        Collections.sort(mostReachUsers, Collections.reverseOrder());
        return mostReachUsers;
    }
}
