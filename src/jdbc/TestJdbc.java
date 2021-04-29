package jdbc;

import java.sql.*;

public class TestJdbc {
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

        // интерфейс, объекты которого умеют отправлять запросы в БД
        Statement statement = null;

        // интерфейс, который получает ответ от Statement, он реализован по паттерну Iterator
        // в каждый момент времения он указывает на одну какую-то строку, в самом начале он стоит перед первой строкой
        ResultSet rows = null;

        try {
            // создаётся стейтмент
            statement = connection.createStatement();

            // отправляем запрос в БД
            rows = statement.executeQuery("select * from account order by id;");

            while (rows.next()) {
                // здесь обращаемся к каждому столбцу выбранной строки и выводим начения
                System.out.printf("%2d|%7s|%20s|%5s|\n",
                        // указываем тип колонки и её название в таблице
                        rows.getInt("id"),
                        rows.getString("first_name"),
                        rows.getString("email"),
                        rows.getInt("experience"),
                        rows.getBoolean("is_active"),
                        rows.getString("phone"));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
