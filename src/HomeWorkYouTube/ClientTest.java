package HomeWorkYouTube;

import HomeWorkYouTube.comment.Comment;
import HomeWorkYouTube.comment.CommentGenerator;
import HomeWorkYouTube.matchers.UserCommentsAndVideos;
import HomeWorkYouTube.matchers.VideoAndComments;
import HomeWorkYouTube.statistic.Statistics;
import HomeWorkYouTube.user.User;
import HomeWorkYouTube.user.UserGenerator;
import HomeWorkYouTube.video.Video;
import HomeWorkYouTube.video.VideoGenerator;

import java.util.List;

public class ClientTest {
    public static void main(String[] args) {

        // нагенерил юзеров
        UserGenerator userGenerator = new UserGenerator();
        List<User> users = userGenerator.generateUsers();

        // нагенерил комментов
        CommentGenerator commentGenerator = new CommentGenerator();
        List<Comment> comments = commentGenerator.generateComments(users);

        // нагенерил видосов
        VideoGenerator videoGenerator = new VideoGenerator();
        List<Video> videoList = videoGenerator.generateVideos(users);

        // добавил комментов к видосам
        VideoAndComments matchVideoAndComments = new VideoAndComments();
        matchVideoAndComments.match(videoList, comments);


        // добавил юзерам видосов и комментов
        UserCommentsAndVideos matchCommentsAndVideos = new UserCommentsAndVideos();
        matchCommentsAndVideos.matchVideosAndComments(users, videoList, comments);

        // Статистика
        Statistics statistics = new Statistics();

        // Отсортированы видео по лайкам и дислайкам
        List<Video> sortedVideos = statistics.showBestRatingVideo(videoList);
        print(sortedVideos);
        System.out.println("----------------------------------------------------");

        // Юзеры в порядке убывания по заработанным деньгам
        List<User> mostReachUsers = statistics.showReachUsers(users);
        print(mostReachUsers);
        System.out.println("----------------------------------------------------");

        // Самые задислайканные комментарии
        List<Comment> reachUsers = statistics.showMostDislikeComments(mostReachUsers);
        print(reachUsers);

        System.out.println("----------------------------------------------------");

    }

    private static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
