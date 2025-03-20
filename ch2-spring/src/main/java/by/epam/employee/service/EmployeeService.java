package by.epam.employee.service;

import by.epam.employee.dto.EmployeeDTO;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    Collection<EmployeeDTO> getAllEmployees();
    Optional<EmployeeDTO> getEmployeeById(Long id);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(long id, EmployeeDTO newEmployeeDTO);
    void deleteEmployee(Long id);
}
