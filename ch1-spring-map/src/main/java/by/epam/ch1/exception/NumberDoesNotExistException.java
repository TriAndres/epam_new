package by.epam.ch1.exception;

public class NumberDoesNotExistException extends RuntimeException {
    public NumberDoesNotExistException(String message) {
        super(message);
    }
}
