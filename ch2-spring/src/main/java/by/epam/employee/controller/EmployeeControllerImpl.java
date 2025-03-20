package by.epam.employee.controller;

import by.epam.employee.dto.EmployeeDTO;
import by.epam.employee.service.EmployeeServiceImpl;
import by.epam.exception.ParameterNotValidException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Override
    @GetMapping
    public Collection<EmployeeDTO> getAllEmployees() {

        log.info("findAll(sort, from, size)");
        return employeeService.getAllEmployees();
    }

    @Override
    @GetMapping("/{numberId}")
    public Optional<EmployeeDTO> getEmployeeById(@PathVariable long numberId) {
        log.info("findById(numberId)");
        return employeeService.getEmployeeById(numberId);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("create(employeeDTO)");
        return employeeService.createEmployee(employeeDTO);
    }

    @Override
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable long id, @Valid @RequestBody EmployeeDTO newEmployeeDTO) {
        log.info("update(newEmployeeDTO)");
        return employeeService.updateEmployee(id, newEmployeeDTO);
    }

    @Override
    @DeleteMapping("/{numberId}")
    public void deleteEmployee(@PathVariable long numberId) {
        log.info("deleteById(numberId)");
        employeeService.deleteEmployee(numberId);
    }
}