package patterns.template_method;

public class SqlDBSever extends StoreInDatabase {

    @Override
    void connection() throws InterruptedException {
        System.out.println("Connection to Postgresql: ");
        for (int i = 0; i < 2; i++) {
            System.out.print(" Please wait... ");
            Thread.sleep(2000);
        }
    }

    @Override
    void write() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Data is stored!");
    }

    @Override
    void closeConnection() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Connection is closed. PostgreSQL.");
    }
}
