package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPrepareStatement {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager
                    .getConnection(
                            "jdbc:postgresql://localhost:5432/javaitis13",
                            "ivan",
                            "postgres");
            Scanner scanner = new Scanner(System.in);
            String carColor = scanner.nextLine();

            // PreparedStatement - позволяет избежать sql инъекций
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into car(color) values (?)");
            // 1 - номер вопросительного знака, setString - обернёт в кавычки
            preparedStatement.setString(1, carColor);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
