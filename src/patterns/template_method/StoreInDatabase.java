package patterns.template_method;

public abstract class StoreInDatabase {


    public void storeData() throws InterruptedException {
        connection();
        write();
        closeConnection();
    }

    abstract void connection() throws InterruptedException;

    abstract void write() throws InterruptedException;

    abstract void closeConnection() throws InterruptedException;
}
