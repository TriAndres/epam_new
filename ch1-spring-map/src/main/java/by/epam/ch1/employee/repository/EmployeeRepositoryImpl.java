package by.epam.ch1.employee.repository;

import by.epam.ch1.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
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
    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(employees.get(id));
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