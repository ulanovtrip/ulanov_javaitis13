package HomeWork5;

// класс для работы с последовательностью чисел



// вставить элемент со сдвигом всех остальных - insert()


import java.util.ArrayList;
import java.util.Random;

public class Sequence implements Observable {

    Random random = new Random();
    private ArrayList<Observer> observers = new ArrayList<>();
    private int size;
    private ArrayList<Integer> sequence;
    private String sequenceId;
    private int bound;

    public Sequence(String sequenceId, int size, int bound) {
        this.bound = bound;
        this.size = size;
        this.sequenceId = sequenceId;
        this.sequence = generateRandomNumbers();
    }

    private ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            temp.add(random.nextInt(10));
        }
        return temp;
    }

    // добавить число в последовательность
    public void add(int num) {
        sequence.add(num);
        notifyObserver("ADD : ", num);
    }

    // удалить число из последовательности по индексу
    // 3, 4, 5 -> removeByIndex(1) -> 3, 5
    public void deleteByIndex(int index) {
        int deletedNm = sequence.remove(index);
        notifyObserver("deleteByIndex", deletedNm);
    }

    // удалить число из последовательности по значению
    // 3, 4, 5 -> removeByValue(5) -> 3, 4
    public void deleteByValue(int value) {
        sequence.remove(Integer.valueOf(value));
        notifyObserver("removeByValue", value);
    }

    // получить элемент по индексу
    public void getByIndex(int index) {
        int currentNum = sequence.get(index);
        notifyObserver("getByIndex", currentNum);
    }

    // вставить элемент в индекс - replace()
    public void replace(int index, int value) {
        sequence.add(index, value);
        notifyObserver("REPLACE", index);
    }

    //добавить число по индексу, остальные сдвинуть.
    public void insert(int index, int value) {
        sequence.add(index, value);
        notifyObserver("INSERT", index);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String event, int value) {
        for (Observer observer : observers) {
            observer.update(event, value);
        }
    }
}
