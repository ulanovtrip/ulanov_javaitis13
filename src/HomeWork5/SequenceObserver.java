package HomeWork5;

// печатает события, которые происходят в конкретном Sequence
// ДОБАВЛЕН ЭЛЕМЕНТ - значение

public class SequenceObserver implements Observer{

    private Observable observable;

    public SequenceObserver(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update(String event, int value) {
        System.out.printf("OPERATION is \"%s\" with VALUE = %d\n", event, value);
    }
}
