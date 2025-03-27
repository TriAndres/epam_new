package by.epam.employee.service;

import by.epam.employee.dto.EmployeeDTO;
import by.epam.employee.model.Employee;
import by.epam.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        employee.setRegistration("false");
        employee.setDataRegistration(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setLogin(employeeDTO.getLogin());
        employee.setPassword(employeeDTO.getPassword());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setSecondName(employeeDTO.getSecondName());
        employee.setEmail(employeeDTO.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return convertToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Convert Employee Entity to EmployeeDTO
    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(),
                employee.getLogin(),
                employee.getPassword(),
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getEmail(),
                employee.getRegistration(),
                employee.getDataRegistration()
        );
    }

    // Convert EmployeeDTO to Employee Entity
    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setLogin(employeeDTO.getLogin());
        employee.setPassword(employeeDTO.getPassword());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setSecondName(employeeDTO.getSecondName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setRegistration(employeeDTO.getRegistration());
        employee.setDataRegistration(employeeDTO.getDataRegistration());
        return employee;
    }
}