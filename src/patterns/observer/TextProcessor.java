package patterns.observer;

// этот интерфейс и есть Observable, за которым наблюдаем
// обработчик документов
public interface TextProcessor {
    // метод обработки массива документов
    void addDocument(String documents);
    // метод для добавления нового наблюдателя
    void addObserver(TextObserver observer);
    // оповещение наблюдателя, что встретили документ.
    void notifyObserver(String document);
}
