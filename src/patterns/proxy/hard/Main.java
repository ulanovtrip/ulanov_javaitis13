package patterns.proxy.hard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String profile = scanner.nextLine();
        MailService mailService;

        if (profile.equals("fake")) {
            mailService = new MailServiceFakeImpl();
        } else {
            mailService = new MailServiceImpl();
        }

        UserServiceProxy userServiceProxy = new UserServiceProxy();

        userServiceProxy.setAfter(email -> {
            mailService.sendMessage(email);
        });

        String email = scanner.nextLine();
        String password = scanner.nextLine();

        userServiceProxy.signUp(email, password);
        userServiceProxy.signIn(email, password);
        userServiceProxy.resetPassword(email);
    }
}
