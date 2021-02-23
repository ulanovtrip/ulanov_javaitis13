package HomeWork5;

public class Main {
    public static void main(String[] args) {
        SequenceGenerator generator = new SequenceGenerator("First", 10, 20);
        Sequence sequence = generator.generateSequence();
        SequenceObserver subscriber = new SequenceObserver(sequence);
        sequence.addObserver(subscriber);

        sequence.add(7);
        sequence.deleteByIndex(7);
        sequence.deleteByValue(5);
        sequence.getByIndex(7);
        sequence.insert(5, 777);
        sequence.replace(3, 13);
        sequence.removeObserver(subscriber);
        System.out.println("----------------------------------------------------------------------------------------");

        SequenceGenerator generator2 = new SequenceGenerator("Second", 30, 25);
        Sequence sequence2 = generator2.generateSequence();
        SequenceObserver subscriber2 = new SequenceObserver(sequence2);
        sequence.addObserver(subscriber2);

        sequence.add(5);
        sequence.deleteByIndex(5);
        sequence.getByIndex(5);
        sequence.insert(9, 555);
        sequence.replace(5, 13);
        sequence2.removeObserver(subscriber2);
    }
}
