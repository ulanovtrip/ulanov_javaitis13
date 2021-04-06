package exceptions.example4;

public class ThrowOwnException {

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        validator.validate("123456");
    }
}

class PasswordValidator {
    public  void validate(String password) {
        if(password.length() < 7) {
            throw new IllegalArgumentException("Your password is sucks!");
        }
    }
}