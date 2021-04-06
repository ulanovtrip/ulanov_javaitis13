package exceptions.bestpractise;

import exceptions.bestpractise.handmadeexception.IllegalPasswordException;

public class PasswordValidator {

    public void validate(String password) {
        if (password.length() < 7) {
            throw new IllegalPasswordException("Your password is sucks! from IllegalPasswordException");
        }
    }
}
