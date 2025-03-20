package by.epam.employee.service;

import by.epam.employee.dto.EmployeeDTO;
import by.epam.employee.mapper.EmployeeMapper;
import by.epam.employee.model.Employee;
import by.epam.employee.repository.EmployeeRepository;
import by.epam.exception.EmployeeDoesNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static by.epam.employee.mapper.EmployeeMapper.convertToDTO;
import static by.epam.employee.mapper.EmployeeMapper.convertToEntity;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;


    @Override
    public Collection<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return Optional.of(employeeRepository
                .findById(id)
                .map(EmployeeMapper::convertToDTO)
                .orElseThrow(() -> new EmployeeDoesNotExistException("Сотрудник не найден.")));
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        return convertToDTO(employeeRepository.save(convertToEntity(employeeDTO)));
    }

    @Override
    public EmployeeDTO updateEmployee(long id, EmployeeDTO newEmployeeDTO) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeDoesNotExistException("Сотрудник не найден."));
        employee.setFirstName(newEmployeeDTO.getFirstName());
        employee.setSecondName(newEmployeeDTO.getSecondName());
        employee.setEmail(newEmployeeDTO.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return convertToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}