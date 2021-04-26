package stream_api.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain1 {
    public static void main(String[] args) {
        List<UserComparable> users = new ArrayList<>();

        UserComparable user0 = new UserComparable(100L, "User1", "User1", 44);
        UserComparable user1 = new UserComparable(22L, "User2", "User2", 30);
        UserComparable user2 = new UserComparable(3L, "User3", "User3", 25);
        UserComparable user3 = new UserComparable(1L, "User4", "User4", 48);
        UserComparable user4 = new UserComparable(40L, "User5", "User5", 10);
        UserComparable user5 = new UserComparable(33L, "User6", "User6", 15);
        UserComparable user6 = new UserComparable(44L, "User7", "User7", 35);
        UserComparable user7 = new UserComparable(8L, "User8", "User8", 44);
        UserComparable user8 = new UserComparable(9L, "User9", "User9", 21);
        UserComparable user9 = new UserComparable(7L, "User10", "User10", 40);


        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);

        Collections.sort(users);
        System.out.println(users);

        System.out.println(user0.compareTo(user1));
    }
}
