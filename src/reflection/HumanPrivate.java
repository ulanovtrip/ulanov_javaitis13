package reflection;

public class HumanPrivate {
    private int age;
    private int height;

    private HumanPrivate() {
        this.age = 99;
        this.height = 182;
    }

    public void show() {
        System.out.println("show!");
    }
}
