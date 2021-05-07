package YouTube.statistic;

import YouTube.comment.Comment;
import YouTube.user.User;
import YouTube.video.Video;

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

        for (int i = 0; i < 10; i++) {

            User user = mostReachUsers.get(i);
            List<Comment> currentUserComments = user.getComments();

            int maxDislikes = 0;
            Comment dislikedComment = null;
            for (Comment comment : currentUserComments) {
                if (comment.getDislikes() > maxDislikes) {
                    maxDislikes = comment.getDislikes();
                    dislikedComment = comment;
                }
            }
            dislikedComments.add(dislikedComment);
        }

        Collections.sort(dislikedComments, Collections.reverseOrder());

        return dislikedComments;
    }
}
