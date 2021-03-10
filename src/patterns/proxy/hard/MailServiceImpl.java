package patterns.proxy.hard;

public class MailServiceImpl implements MailService{
    public void sendMessage(String email) {
        System.out.println("Sent on Email " + email);
    }
}
