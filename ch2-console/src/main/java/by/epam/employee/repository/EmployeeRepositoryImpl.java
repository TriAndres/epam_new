package by.epam.employee.repository;

import by.epam.employee.modell.Employee;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<Long, Employee> employees = new HashMap<>();

    @Override
    public Collection<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }
}