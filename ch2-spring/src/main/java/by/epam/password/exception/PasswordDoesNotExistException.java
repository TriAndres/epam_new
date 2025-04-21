package by.epam.password.exception;

public class PasswordDoesNotExistException extends RuntimeException {
    public PasswordDoesNotExistException(String message) {
        super(message);
    }
}