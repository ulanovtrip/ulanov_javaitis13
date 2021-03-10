package patterns.observer;

public class CertificateObserver implements TextObserver {

    private final static String CERTIFICATE_SIGN = "Справка";

    @Override
    public void handleDocument(String document) {
        if (document.contains(CERTIFICATE_SIGN)) {
            System.out.println("Справка передана в печать!");
        }
    }
}
