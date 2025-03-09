package by.epam.employee.repository;

import by.epam.employee.model.Employee;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(long id);

    void deleteById(long id);

    void deleteAll();
}
