package exceptions.bestpractise.handmadeexception;

import exceptions.bestpractise.PasswordValidator;

public class TestHandMade {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        validator.validate("1234");
    }
}
