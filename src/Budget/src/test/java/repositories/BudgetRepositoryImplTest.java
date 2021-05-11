package repositories;

import com.github.npathai.hamcrestopt.OptionalMatchers;
import models.Purchase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

class BudgetRepositoryImplTest {

    BudgetRepositoryImpl budgetRepository;
    EmbeddedDatabase embeddedDatabase;

    @BeforeEach
    void setUp() {
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("sql/schema.sql")
                .addScript("sql/data.sql")
                .build();

        budgetRepository = new BudgetRepositoryImpl(embeddedDatabase);
    }

    @AfterEach
    void shutDown() {
        embeddedDatabase.shutdown();
    }

    @Test
    void create() {
        budgetRepository.create(
                Purchase.builder()
                        .id(6)
                        .title("Taxi")
                        .sum(326L)
                        .dateTime("2021-06-03")
                        .build()
        );
        assertThat(budgetRepository.readById(6L), OptionalMatchers.isPresentAndIs(purchaseIdSix()));
    }

    @ParameterizedTest(name = "method returns {0}")
    @MethodSource("expectedPurchaseProvider")
    void readById(Purchase expectedPurchased) {
        Optional<Purchase> purchase = budgetRepository.readById(3L);
        assertThat(purchase, OptionalMatchers.isPresentAndIs(expectedPurchased));
    }

    @Test
    @DisplayName("find by title returns correct objects")
    void find_by_title_returns_correct_objects() {
        List<Purchase> purchaseList = budgetRepository.findAllByTitle("Cheese");
        assertThat(purchaseList, containsInAnyOrder(expectedPurchases().toArray()));
    }

    @Test
    @DisplayName("findAllByTitle return not empty list")
    void findAllByTitle() {
        List<Purchase> purchaseList = budgetRepository.findAllByTitle("Cheese");
        assertThat(purchaseList, is(not(empty())));
    }

    // обект для create()
    private static Purchase purchaseIdSix() {
        return Purchase.builder()
                .id(6)
                .title("Taxi")
                .sum(326L)
                .dateTime("2021-06-03")
                .build();
    }

    // создадим ожидаемый объект для сравнения
    private static Stream<Purchase> expectedPurchaseProvider() {
        return Stream.of(Purchase.builder()
                .id(3)
                .title("Cheese")
                .sum(100L)
                .dateTime("2021-06-03")
                .build());
    }

    // создадим объекты которые ожидаем получить из БД
    private static List<Purchase> expectedPurchases() {
        return Arrays.asList(
                Purchase.builder()
                        .id(3)
                        .title("Cheese")
                        .sum(100L)
                        .dateTime("2021-06-03")
                        .build(),

                Purchase.builder()
                        .id(4)
                        .title("Cheese")
                        .sum(200L)
                        .dateTime("2021-06-03")
                        .build(),

                Purchase.builder()
                        .id(5)
                        .title("Cheese")
                        .sum(300L)
                        .dateTime("2021-06-03")
                        .build()
        );
    }
}