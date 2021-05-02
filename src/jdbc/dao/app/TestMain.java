package jdbc.dao.app;

import jdbc.dao.models.Account;
import jdbc.dao.repositories.AccountsRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMain {
    public static void main(String[] args) {

        try {
            // загрузка драйвера в вертуальную машину
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        // DriverManager - сканирует подключенные классы-реализации Driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaitis13", "ivan", "postgres");
        } catch (SQLException e) {
            // если подключения не произошло, то будет исключение и программа остановится, это best practice
            throw new IllegalArgumentException(e);
        }

        // сей объект нужен для работы с БД, это есть DAO, там реализация методов CRUD
        AccountsRepositoryJdbcImpl repositoryJdbc = new AccountsRepositoryJdbcImpl(connection);

        System.out.println("-----------------------------------------------------------------------------------------");
        // проверка работы метода findAll
        System.out.println(repositoryJdbc.findAll());
        System.out.println("-----------------------------------------------------------------------------------------");
        // провека работы findById()
        System.out.println("ID 1L is: " + repositoryJdbc.findById(1L));
        System.out.println("-----------------------------------------------------------------------------------------");
        // проверка работы save()
        // Account ivan = new Account("Ivan", "Ulanov", true);
        //repositoryJdbc.save(ivan);
        System.out.println(repositoryJdbc.findById(9L));
        System.out.println("-----------------------------------------------------------------------------------------");
        // проверим работу update()
        //Account account = new Account(9L, "Baklan", "Morskoy", true);
        //repositoryJdbc.update(account);
        // или так
        Account isak = repositoryJdbc.findById(2L);
        isak.setLastName("Clark");
        repositoryJdbc.save(isak);

    }
}
