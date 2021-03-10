package patterns.proxy.hard;

public class UserServiceProxy extends UserService {

    private After after;

    public void setAfter(After after) {
        this.after = after;
    }

    @Override
    public void signUp(String email, String password) {
        super.signUp(email, password);
        if (after != null) {
            after.execute(email);
        }
    }

    @Override
    public void signIn(String email, String password) {
        super.signIn(email, password);
        if (after != null) {
            after.execute(email);
        }
    }

    @Override
    public void resetPassword(String email) {
        super.resetPassword(email);
        if (after != null) {
            after.execute(email);
        }
    }
}
