package patterns.proxy.hard;

public class UserService {
    public void signUp(String email, String password) {
        System.out.println("Sign up Success!");
    }

    public void signIn(String email, String password) {
        System.out.println("sign in success!");
    }

    public void resetPassword(String email) {
        System.out.println("Заявлка на восстановление пароля отправлена");
    }
}
