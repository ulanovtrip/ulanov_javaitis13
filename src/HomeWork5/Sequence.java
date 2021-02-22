package HomeWork5;

// класс для работы с последовательностью чисел

// добавить число в последовательность
// удалить число из последовательности по индексу
// 3, 4, 5 -> removeByIndex(1) -> 3, 5

// удалить число из последовательности по значению
// 3, 4, 5 -> removeByValue(5) -> 3, 4

// получить элемент по индексу
// вставить элемент в индекс - replace()
// вставить элемент со сдвигом всех остальных - insert()


import java.util.ArrayList;

public class Sequence implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();
    int[] sequence;

    public Sequence(int[] sequence) {
        this.sequence = sequence;
    }

    public void add(int num) {

        notifyObserver("ADD : ", num);
    }

    public void deleteByIndex(int index) {
        notifyObserver("deleteByIndex", index);
    }

    public int getByIndex(int index) {
        notifyObserver("getByIndex", index);
        return 0;
    }

    public void replace(int index) {
        notifyObserver("REPLACE", index);
    }

    public void insert(int index) {
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
