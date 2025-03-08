package by.epam.employee.repository;

import by.epam.employee.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class employeeRepositoryImpl implements employeeRepository {
    private final Map<Long, Employee> employees = new HashMap<>();

}
