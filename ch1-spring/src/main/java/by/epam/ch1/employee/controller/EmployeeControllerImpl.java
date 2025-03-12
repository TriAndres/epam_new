package by.epam.ch1.employee.controller;

import by.epam.ch1.employee.model.Employee;
import by.epam.ch1.employee.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Override
    @GetMapping
    public Collection<Employee> findAll() {
        log.info("findAll()");
        return employeeService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody Employee employee) {
        log.info("create(employee)");
        return employeeService.create(employee);
    }

    @Override
    @PutMapping
    public Employee update(@Valid @RequestBody Employee newEmployee) {
        log.info("update(newEmployee)");
        return employeeService.update(newEmployee);
    }

    @Override
    @GetMapping("/{numberId}")
    public Optional<Employee> findById(@PathVariable long numberId) {
        log.info("findById(numberId)");
        return employeeService.findById(numberId);
    }

    @Override
    @DeleteMapping("/{numberId}")
    public void deleteById(@PathVariable long numberId) {
        log.info("deleteById(numberId)");
        employeeService.deleteById(numberId);
    }

    @Override
    @DeleteMapping
    public void deleteAll() {
        log.info("deleteAll()");
        employeeService.findAll();
    }
}