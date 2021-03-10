package patterns.observer;

import javax.sound.midi.Soundbank;

// конкретный Observable, т.е. конкретный наблюдаемый объект
public class TextProcessorImpl implements TextProcessor {

    // максимальное кол-во наблюдателей
    private static final int MAX_OBSERVERS_COUNT = 5;

    // массив наблюдателей
    private TextObserver[] observers;
    // текущее колличество наблюдателей
    private int countObservers;

    public TextProcessorImpl() {
        this.observers = new TextObserver[MAX_OBSERVERS_COUNT];
    }

    @Override
    public void addDocument(String document) {
        // вывод инфо, что документ получен
            System.out.println("Получен документ : " + document);
            // оповестить обработчика(observer), что появился новый документ.
            notifyObserver(document);
    }

    @Override
    public void addObserver(TextObserver observer) {
        if (countObservers < MAX_OBSERVERS_COUNT) {
            this.observers[countObservers] = observer;
            countObservers++;
        } else {
            System.err.println("Превышено кол-во допустимых обработчиков.");
        }
    }

    @Override
    public void notifyObserver(String document) {
        // проходим по всем наблюдателям
        for (int i = 0; i < countObservers; i++) {
            // вызываем на каждом метод обработки события
            observers[i].handleDocument(document);
        }
    }
}
