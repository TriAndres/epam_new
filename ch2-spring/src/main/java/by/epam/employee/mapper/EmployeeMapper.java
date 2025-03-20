package by.epam.employee.mapper;

import by.epam.employee.dto.EmployeeDTO;
import by.epam.employee.model.Employee;

public class EmployeeMapper {
    public static EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getSecondName(), employee.getEmail());
    }

    public static Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setSecondName(employeeDTO.getSecondName());
        employee.setEmail(employeeDTO.getEmail());
        return employee;
    }
}
