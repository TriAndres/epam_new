package by.epam.ch1.employee.repository;

import by.epam.ch1.employee.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {
    Collection<Employee> findAll();

    Employee save(Employee employee);

    Optional<Employee> findById(long id);

    void deleteById(long id);

    void deleteAll();
}