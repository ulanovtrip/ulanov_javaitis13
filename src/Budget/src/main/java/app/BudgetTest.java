package app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.Purchase;
import repositories.BudgetRepository;
import repositories.BudgetRepositoryImpl;

import java.time.LocalDateTime;

public class BudgetTest {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/javaitis13";
        String user = "ivan";
        String password = "postgres";

        // использование библиотеки connection pool
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(50);

        HikariDataSource hikariDataSource = new HikariDataSource(config);

        // создаём наш репозиторий и передаём ему datasource
        BudgetRepository budgetRepository = new BudgetRepositoryImpl(hikariDataSource);


        // сделаем новую запись
//        budgetRepository.create(
//                Purchase.builder()
//                        .title("Сыр")
//                        .sum(100L)
//                        .dateTime(String.valueOf(LocalDateTime.now().toLocalDate()))
//                        .build()
//        );

        System.out.println(budgetRepository.findAllByTitle("Сыр"));

        System.out.println(budgetRepository.readById(1L));
    }
}
