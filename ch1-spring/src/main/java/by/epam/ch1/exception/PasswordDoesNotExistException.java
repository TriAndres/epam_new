package by.epam.ch1.exception;

public class PasswordDoesNotExistException extends RuntimeException {
    public PasswordDoesNotExistException(String message) {
        super(message);
    }
}