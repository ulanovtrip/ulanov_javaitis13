package exceptions.bestpractise.handmadeexception;

public class IllegalPasswordException extends RuntimeException {

    public IllegalPasswordException(String message) {
        super(message);
    }
}
