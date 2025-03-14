package by.epam.ch1.employee.service;

import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.employee.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    ;Collection<Employee> findAll(SortOrderE sort, int from, int size);

    Employee create(Employee employee);

    Employee update(Employee newEmployee);

    Optional<Employee> findById(long id);

    void deleteById(long id);

    void deleteAll();
}