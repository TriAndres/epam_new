package by.epam.exception;

public class NumbersDoesNotExistException extends RuntimeException {
    public NumbersDoesNotExistException(String message) {
        super(message);
    }
}