package multithreading.itis.resources;

public class MainTest {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1000);

        Human husband = new Human("HorseBand", creditCard);
        Human wife = new Human("Wife", creditCard);

        wife.start();
        husband.start();

    }
}
