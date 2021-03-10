package patterns.template_method;

import java.util.Scanner;

public class MainTest {
    private static final String SQL_DB = "sql";
    private static final String NO_SQL_DB = "no_sql";

    public static void main(String[] args) throws InterruptedException {
        StoreInDatabase storeInDatabase;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input data: ");
        String data = scanner.nextLine();
        System.out.println("Input name of DB: ");
        String namdDb = scanner.nextLine();

        if (namdDb.equals(SQL_DB)) {
            storeInDatabase = new SqlDBSever();
            storeInDatabase.storeData();
        }

        if (namdDb.equals(NO_SQL_DB)) {
            storeInDatabase = new NoSqlDBSaver();
            storeInDatabase.storeData();
        }
    }
}
