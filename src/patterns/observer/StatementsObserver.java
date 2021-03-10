package patterns.observer;

public class StatementsObserver implements TextObserver {
    private final static String STATEMENT_SIGN = "Заявление";

    @Override
    public void handleDocument(String document) {
        // если это заявление
        if (document.contains(STATEMENT_SIGN)) {
            System.out.println("Отправлено в соответствующий отдел!");
        }
    }
}
