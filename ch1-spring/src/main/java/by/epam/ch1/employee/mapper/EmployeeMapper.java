package by.epam.ch1.employee.mapper;

import by.epam.ch1.employee.dto.EmployeeDTO;
import by.epam.ch1.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO
                .builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .SecondName(employee.getSecondName())
                .from(employee.getFrom())
                .to(employee.getTo())
                .build();
    }

    public static List<EmployeeDTO> toListDTO(List<Employee> employees) {
        return employees
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    public static Employee toModel(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .secondName(employeeDTO.getSecondName())
                .from(employeeDTO.getFrom())
                .to(employeeDTO.getTo())
                .build();
    }

    public static List<Employee> toListModel(List<EmployeeDTO> employeeDTOS) {
        List<Employee> list = new ArrayList<>();
        for (EmployeeDTO dto : employeeDTOS) {
            list.add(toModel(dto));
        }
        return list;
    }
}