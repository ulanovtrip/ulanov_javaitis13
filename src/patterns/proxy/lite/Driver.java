package patterns.proxy.lite;

public class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public void drive() {
        System.out.println(name + " is driven!");
    }

    public String getName() {
        return name;
    }
}
