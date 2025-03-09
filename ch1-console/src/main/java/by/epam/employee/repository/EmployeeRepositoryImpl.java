package by.epam.employee.repository;

import by.epam.employee.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<Long, Employee> employees = new HashMap<>();

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee save(Employee employee) {
        return employees.put(employee.getId(), employee);
    }

    @Override
    public Employee findById(long id) {
        return employees.get(id);
    }

    @Override
    public void deleteById(long id) {
        employees.remove(id);
    }

    @Override
    public void deleteAll() {
        employees.clear();
    }
}