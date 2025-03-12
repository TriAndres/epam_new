package by.epam.ch1.employee.controller;

import by.epam.ch1.employee.model.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeController {
    Collection<Employee> findAll();

    Employee create(@Valid @RequestBody Employee employee);

    Employee update(@Valid @RequestBody Employee newEmployee);

    Optional<Employee> findById(@PathVariable long numberId);

    void deleteById(@PathVariable long numberId);

    void deleteAll();
}