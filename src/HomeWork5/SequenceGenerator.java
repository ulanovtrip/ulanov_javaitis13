package HomeWork5;

public class SequenceGenerator {

    private int size;
    private int bound;
    private String id;

    public SequenceGenerator(String id, int size, int bound) {
        this.id = id;
        this.bound = bound;
        this.size = size;
    }

    public Sequence generateSequence() {
        return new Sequence(id, size, bound);
    }
}
