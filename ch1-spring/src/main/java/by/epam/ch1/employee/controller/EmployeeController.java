package by.epam.ch1.employee.controller;

import by.epam.ch1.employee.model.Employee;
import by.epam.ch1.employee.service.EmployeeService;
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
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping
    public Employee update(@Valid @RequestBody Employee newEmployee) {
        return employeeService.update(newEmployee);
    }

    @GetMapping("/{numberId}")
    public Optional<Employee> findById(@PathVariable long numberId) {
        return employeeService.findById(numberId);
    }

    @DeleteMapping("/{numberId}")
    public void deleteById(@PathVariable long numberId) {
        employeeService.deleteById(numberId);
    }

    @DeleteMapping
    public void deleteAll() {
        employeeService.findAll();
    }
}