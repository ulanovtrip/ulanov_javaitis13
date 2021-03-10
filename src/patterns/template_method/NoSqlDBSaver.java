package patterns.template_method;

public class NoSqlDBSaver extends StoreInDatabase{

    @Override
    void connection() throws InterruptedException {
        System.out.println("Connection to MongoDB: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(" Please wait... ");
            Thread.sleep(1000);
        }
    }

    @Override
    void write() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("JSON file is stored!");
    }

    @Override
    void closeConnection() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Connection is closed. MongoDB.");
    }
}
