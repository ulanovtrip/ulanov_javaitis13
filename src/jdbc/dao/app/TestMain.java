package jdbc.dao.app;

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

        AccountsRepositoryJdbcImpl repositoryJdbc = new AccountsRepositoryJdbcImpl(connection);
        System.out.println(repositoryJdbc.findAll());
    }
}
