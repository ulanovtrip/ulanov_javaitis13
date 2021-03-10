package patterns.factory_method;

import java.time.LocalTime;

public class CertificatesGenerator implements DocumentGenerator {
    @Override
    public Document generate(String text) {
        return new Certificate("Справка от " + LocalTime.now(), text);
    }
}
