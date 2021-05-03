package annotations.runtime;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientMain {
    public static void main(String[] args) throws Exception {

//        DataSource dataSource =
//                new DriverManagerDataSource("jdbc:postgresql://localhost:5432/javaitis13", "ivan", "postgres");

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaitis13", "ivan", "postgres");

        // проверка работы генератора
        SqlTablesGenerator generator = new SqlTablesGenerator(connection);

        // вызов метода
        generator.generateSQL(Course.class); // '.class' is used when there isn't an instance of the class available.
    }
}
