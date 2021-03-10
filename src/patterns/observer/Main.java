package patterns.observer;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextProcessor textProcessor = new TextProcessorImpl();
        textProcessor.addObserver(new StatementsObserver());
        textProcessor.addObserver(new CertificateObserver());
        textProcessor.addObserver(document -> {
            System.err.println("Документ <" + document.split(" ")[0] + "> получен в "
                    + LocalTime.now().getHour() + ":"
                    + LocalTime.now().getMinute()
                    + ":" + LocalTime.now().getSecond());
        });

        //String[] documents = {"Заявление 1", "Справка 2", "Разрешение 3"};

        while (true) {
            String document = scanner.nextLine();
            textProcessor.addDocument(document);
        }
    }
}
