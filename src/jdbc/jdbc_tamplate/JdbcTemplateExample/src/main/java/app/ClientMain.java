package app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import repositories.AccountsRepository;
import repositories.AccountsRepositoryJdbcTemplateImpl;
import ru.itis.site.models.Account;

import java.util.Optional;

public class ClientMain {
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
        AccountsRepository accountsRepository = new AccountsRepositoryJdbcTemplateImpl(hikariDataSource);

        System.out.println(accountsRepository.findAll());

        Optional<Account> account = accountsRepository.findById(5L);

        // Optional гарантирует, что мы всегда что-то получим при вызове метод
        // и нужно всегда проверять, есть ли он, т.к. его может и не быть
        if (account.isPresent()) {
            Account prsentedAccount = account.get();
            System.out.println(prsentedAccount);
        } else {
            System.out.println("Object not found!");
        }

        // сохраним новую запись, закоментил, чтобы не поломалось
//        accountsRepository.save(
//                Account.builder()
//                        .firstName("Mocky")
//                        .lastName("Gordon")
//                        .isActive(true)
//                        .build()
//        );


    }
}
