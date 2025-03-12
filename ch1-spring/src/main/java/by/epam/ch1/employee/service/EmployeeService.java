package by.epam.ch1.employee.service;

import by.epam.ch1.employee.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    ;Collection<Employee> findAll();

    Employee create(Employee employee);

    Employee update(Employee newEmployee);

    Optional<Employee> findById(long id);

    void deleteById(long id);

    void deleteAll();
}