package HomeWork5;

public interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String event, int value);
}
