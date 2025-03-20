package by.epam.exception;

import by.epam.employee.model.Employee;

import java.util.function.Supplier;

public class EmployeeDoesNotExistException extends RuntimeException implements Supplier<Employee> {
    public EmployeeDoesNotExistException(String message) {
        super(message);
    }

    @Override
    public Employee get() {
        return null;
    }
}