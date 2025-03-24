package by.epam.exception;

public class PasswordDoesNotExistException extends RuntimeException {
    public PasswordDoesNotExistException(String message) {
        super(message);
    }
}