package stream_api.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<UserComparator> users = new ArrayList<>();

        UserComparator user0 = new UserComparator(100L, "User1", "User1", 44);
        UserComparator user1 = new UserComparator(22L, "User2", "User2", 30);
        UserComparator user2 = new UserComparator(3L, "User3", "User3", 25);
        UserComparator user3 = new UserComparator(1L, "User4", "User4", 48);
        UserComparator user4 = new UserComparator(40L, "User5", "User5", 10);
        UserComparator user5 = new UserComparator(33L, "User6", "User6", 15);
        UserComparator user6 = new UserComparator(44L, "User7", "User7", 35);
        UserComparator user7 = new UserComparator(8L, "User8", "User8", 44);
        UserComparator user8 = new UserComparator(9L, "User9", "User9", 21);
        UserComparator user9 = new UserComparator(7L, "User10", "User10", 40);


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

        // сортировка с помощью Comparator
        //Collections.sort(users, new UserByIdComparator());

        // чтобы не создавать новый класс, можно реализовать лямбда-выражение
        Collections.sort(users, (userFirst, userSecond) -> {
           return Long.compare(userFirst.getId(), userSecond.getId());
        });

        // либо сокращённо
        //Collections.sort(users, Comparator.comparingLong(UserComparator::getId));

        System.out.println(users);
    }
}
