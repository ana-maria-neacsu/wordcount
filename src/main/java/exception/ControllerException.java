package exception;

public class ControllerException extends RuntimeException {
    public ControllerException(final String message) {
        super(message);
    }
}