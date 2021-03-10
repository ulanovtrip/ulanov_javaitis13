package patterns.factory_method;

import java.time.LocalTime;

public class StatementsGenerator implements DocumentGenerator {
    @Override
    public Document generate(String text) {
        return new Statement("Заявление от " + LocalTime.now(), text);
    }
}
