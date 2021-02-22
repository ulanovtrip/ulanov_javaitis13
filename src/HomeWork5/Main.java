package HomeWork5;

public class Main {
    public static void main(String[] args) {
        SequenceGenerator generator = new SequenceGenerator(10);
        Sequence sequence = new Sequence(generator.generateSequence());
        SequenceObserver subscriber = new SequenceObserver(sequence);
        sequence.addObserver(subscriber);

        sequence.add(7);
        sequence.deleteByIndex(7);
        sequence.getByIndex(7);
        sequence.insert(7);
        sequence.replace(7);

        sequence.removeObserver(subscriber);
    }
}
