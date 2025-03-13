package by.epam.ch1.exception;

public class EmployeeDoesNotExistException extends RuntimeException {
    public EmployeeDoesNotExistException(String message) {
        super(message);
    }
}