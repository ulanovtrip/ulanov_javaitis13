package HomeWork5;

// класс для работы с последовательностью чисел
// вставить элемент со сдвигом всех остальных - insert()

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Sequence implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();
    private int size;
    private int[] sequence;
    private String sequenceId;
    private int bound;

    public Sequence(String sequenceId, int size, int bound) {
        this.bound = bound;
        this.size = size;
        this.sequenceId = sequenceId;
        generateRandomNumbers();
    }

    //заполняем последовательность -1, что будет значить, что она пуста
    private void generateRandomNumbers() {
        sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = -1;
        }
    }

    // добавить число в последовательность
    public void add(int num) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == -1) {
                sequence[i] = num;
                break;
            }

            //если прошлись и не нашли места для вставки
            if (i == sequence.length - 1) {
                //копируем во временный массив
                int[] temp = new int[sequence.length];
                for (int j = 0; j < sequence.length; j++) {
                    temp[j] = sequence[j];
                }
                //увеличиваем размер последовательности
                sequence = new int[size * 2];
                //добиваем новые пустые ячейки значением пустоты, т.е. -1
                sequence = IntStream.generate(() -> -1).limit(sequence.length).toArray();
                for (int j = 0; j < temp.length; j++) {
                    sequence[j] = temp[j];
                }
                sequence[sequence.length - temp.length] = num;
                break;
            }
        }
        notifyObserver("ADD : ", num);
    }

    // удалить число из последовательности по индексу
    // 3, 4, 5 -> removeByIndex(1) -> 3, 5
    public void deleteByIndex(int index) {
        //запомним число под индексом для вывода
        int remembered = sequence[index];
        //запишем вместо удаляемого числа -2, чтобы поймать его потом.
        sequence[index] = -2;
        //создаю временный массив -1 эелемент
        sequence = shiftSequence();
        notifyObserver("deleteByIndex", remembered);
    }

    public int[] shiftSequence() {
        int[] temp = new int[sequence.length - 1];

        //переменная для индексов временного массива
        int numTempCell = 0;
        for (int i = 0; i < sequence.length; i++) {
            //когда пападается число -2 в исходной последовательности
            if (sequence[i] == -2) {
                //пропускаю его и пишу во временный массив следующий за ним эелемент
                temp[numTempCell++] = sequence[++i];
            } else {
                temp[numTempCell++] = sequence[i];
            }
        }
        // присваиваю исходной последовательности значение временного с удалённым элементом
        return temp;
    }

    // удалить число из последовательности по значению
    // 3, 4, 5 -> removeByValue(5) -> 3, 4
    public void deleteByValue(int value) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == value) {
                sequence[i] = -2;
                break;
            }
        }

        sequence = shiftSequence();
        notifyObserver("removeByValue", value);
    }

    // получить элемент по индексу
    public void getByIndex(int index) {
        if (index < sequence.length) {
            int fountNum = sequence[index];
            notifyObserver("getByIndex", fountNum);
        } else {
            System.out.println("Index out of bounds!");
        }
    }

    // вставить элемент в индекс - replace()
    public void replace(int index, int value) {
        int currentNum = sequence[index];
        sequence[index] = value;
        notifyObserver("REPLACE " + currentNum, value);
    }

    //добавить число по индексу, остальные сдвинуть.
    public void insert(int index, int value) {
        int indexOfTemp = 0;
        int[] temp = new int[sequence.length + 1];
        for (int i = 0; i < sequence.length; i++) {
            if (i == index) {
                int remembered = sequence[index];
                temp[indexOfTemp++] = value;
                temp[indexOfTemp++] = remembered;
            } else {
                temp[indexOfTemp++] = sequence[i];
            }
        }
        sequence = temp;
        notifyObserver("INSERT by Index " + index, value);
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

    public class SequenceIterator {
        //написать итератор по самой последовательности, нужно заменить последовательность на массив
        private int[] sequence;

        public SequenceIterator() {
            this.sequence = Sequence.this.sequence;
        }

        public void printSequence() {
            System.out.print(sequenceId + " Sequence: ");
            for (int i = 0; i < sequence.length; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
        }
    }
}
