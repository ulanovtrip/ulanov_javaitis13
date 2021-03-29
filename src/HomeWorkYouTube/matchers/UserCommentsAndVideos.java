package HomeWorkYouTube.matchers;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.user.User;
import HomeWorkYouTube.video.Video;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class UserCommentsAndVideos {

    SecureRandom random = new SecureRandom();

    public void matchVideosAndComments(List<User> users, List<Video> videos, List<Comment> comments) {

        for (int i = 0; i < users.size(); i++) {
            users.get(i).setVideoList(randomVideos(random.nextInt(20), videos));
            users.get(i).setComments(randomComments(random.nextInt(30), comments));
        }
    }

    private List<Video> randomVideos(int valueOfVideos, List<Video> videos) {
        List<Video> list = new ArrayList<>();
        for (int i = 0; i < valueOfVideos; i++) {
            list.add(videos.get(random.nextInt(videos.size())));
        }
        return list;
    }

    private List<Comment> randomComments(int valueOfComments, List<Comment> comments) {
        List<Comment> list = new ArrayList<>();
        for (int i = 0; i < valueOfComments; i++) {
            list.add(comments.get(random.nextInt(comments.size())));
        }
        return list;
    }
}
