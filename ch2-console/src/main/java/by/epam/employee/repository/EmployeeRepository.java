package by.epam.employee.repository;

import by.epam.employee.modell.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {
    Collection<Employee> findAll();

    Employee save(Employee employee);

    Optional<Employee> findById(long id);

    void deleteById(long id);

    void deleteAll();
}
