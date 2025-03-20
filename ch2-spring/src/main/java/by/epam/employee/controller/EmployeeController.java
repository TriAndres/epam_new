package by.epam.employee.controller;

import by.epam.employee.dto.EmployeeDTO;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeController {
    Collection<EmployeeDTO> getAllEmployees();

    Optional<EmployeeDTO> getEmployeeById(long numberId);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(long id, EmployeeDTO newEmployeeDTO);

    void deleteEmployee(long numberId);
}