package patterns.proxy.lite;

public class Main {
    public static void main(String[] args) {
        DriverProxy ivan = new DriverProxy("Ivan");

        // реализация функционального интерфейса Before в лямбде
        ivan.setBefore(() -> {
            System.out.println(ivan.getName() + " собрался поехать!");
        });

        ivan.setAfter(() -> {
            System.out.println("А не кукухой ли?");
        });

        ivan.setInstead(() -> {
            System.out.println("Куда-то он поехал...");
        });

        //ivan.drive();

        Driver victor = new Driver("Victor");
        Driver airat = new Driver("Айрат");

        Driver[] drivers = {ivan, victor, airat};

        for (int i = 0; i < drivers.length; i++) {
            drivers[i].drive();
            System.out.println("++++++++++++++++++");
        }
    }
}
