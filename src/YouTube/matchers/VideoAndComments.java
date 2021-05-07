package YouTube.matchers;

import YouTube.comment.Comment;
import YouTube.video.Video;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class VideoAndComments {

    SecureRandom random = new SecureRandom();

    public void match(List<Video> videos, List<Comment> comments) {


        for (int i = 0; i < videos.size(); i++) {
            int numberOfComments = random.nextInt(30);
            videos.get(i).setCommentList(randomComments(numberOfComments, comments));
        }
    }


    private List<Comment> randomComments(int numberOfComments, List<Comment> comments) {
        List<Comment> list = new ArrayList<>();
        for (int i = 0; i < numberOfComments; i++) {
            list.add(comments.get(Math.abs(random.nextInt(comments.size()))));
        }
        return list;
    }
}
