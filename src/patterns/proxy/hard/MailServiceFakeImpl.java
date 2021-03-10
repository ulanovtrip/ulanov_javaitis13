package patterns.proxy.hard;

public class MailServiceFakeImpl implements MailService{
    public void sendMessage(String message) {
        System.out.println("Request accepted. Email not send.");
    }
}
