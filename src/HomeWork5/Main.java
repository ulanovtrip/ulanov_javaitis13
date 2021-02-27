package HomeWork5;

public class Main {
    public static void main(String[] args) {
        SequenceGenerator generator = new SequenceGenerator("First", 3, 20);
        Sequence sequence = generator.generateSequence();
        SequenceObserver subscriber = new SequenceObserver(sequence);
        sequence.addObserver(subscriber);

        System.out.println("----------------------------------------------------------------------------------------");
        sequence.add(1);
        sequence.add(12);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);
        sequence.deleteByIndex(3);
        sequence.deleteByValue(12);
        sequence.add(77);
        sequence.getByIndex(3);
        sequence.replace(3, 88);
        sequence.insert(0, 13);

        Sequence.SequenceIterator iterator = sequence.new SequenceIterator();
        iterator.printSequence();

        sequence.removeObserver(subscriber);
        System.out.println("----------------------------------------------------------------------------------------");

        SequenceGenerator generator2 = new SequenceGenerator("Second", 5, 15);
        Sequence sequence2 = generator2.generateSequence();
        SequenceObserver subscriber2 = new SequenceObserver(sequence2);
        sequence2.addObserver(subscriber2);

        sequence2.add(55);
        sequence2.add(32);
        sequence2.add(11);
        sequence2.add(7);
        sequence2.add(3);
        sequence2.deleteByIndex(2);
        sequence2.deleteByValue(55);
        sequence2.add(111);
        sequence2.getByIndex(5);
        sequence2.replace(1, 444);
        sequence2.insert(3, 999);

        Sequence.SequenceIterator iterator2 = sequence2.new SequenceIterator();
        iterator2.printSequence();

        sequence.removeObserver(subscriber2);
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
