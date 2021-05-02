package reflection;

public class HumanReflection {
    private int age;
    double height;

    public void printAge() {
        System.out.println(age);
    }

    public void grow(double value) {
        this.height += value;
    }

    public void grow() {
        this.height += 0.01;
    }

    public double getHeight() {
        return this.height;
    }

    private double simplePrivate() {
        System.out.println("I'm private from Human");
        return height;
    }
}
