package stream_api.streams;

import stream_api.comparable_comparator.UserComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
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

        List<UserComparator> users = new ArrayList<>();
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

        // задача: распечатать id пользователей у которых возраст более 30-ти лет

        // берём поток пользователей
        Stream<UserComparator> userStream = users.stream();

        // далее получить пользователей с возрастом более 30-ти лет

        // для метода filter нам нужен предикат
        Predicate<UserComparator> ageMoreThan30 = new Predicate<UserComparator>() {
            @Override
            public boolean test(UserComparator userComparator) {
                // данный предикат вернёт true или false, в зависимости от результата
                return userComparator.getAge() > 30;
            }
        };

        // тут отфильтрует тех пользователей, которые старше 30-ти
        Stream<UserComparator> filteredUsers = userStream.filter(ageMoreThan30);

        // отсортировать пользователей по возрасту

        // сначала нужен comparator
        // comparingInt(UserComparator::getAge) - сравнит по возрасту
        Comparator<UserComparator> usersComparator = Comparator.comparingInt(UserComparator::getAge);

        // сортируем
        Stream<UserComparator> sortedByAge = filteredUsers.sorted(usersComparator);

        // Получаем id пользователя

        // сначала нужно сделать функцию для извлечения id
        Function<UserComparator, Long> getIdFunction = user -> user.getId();

        // передаём эту функцию в map
        Stream<Long> ids = sortedByAge.map(getIdFunction);

        // распечаем id пользователей
        // создадим сначала consumer, он принимает на вход id и на выходе печатает его
        Consumer<Long> printId = id -> System.out.println(id);
        // затем для каждого элемента распечатаем его id через foreach
         ids.forEach(printId);
    }
}
