package by.epam.ch1.employee.controller;

import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.employee.dto.EmployeeDTO;
import by.epam.ch1.employee.service.EmployeeServiceImpl;
import by.epam.ch1.exception.ParameterNotValidException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Override
    @GetMapping
    public Collection<EmployeeDTO> findAll(@RequestParam(defaultValue = "desk") String sort,
                                           @RequestParam(defaultValue = "0") int from,
                                           @RequestParam(defaultValue = "10") int size) {
        SortOrderE sortOrderE = SortOrderE.from(sort);
        if (sortOrderE == null) {
            throw new ParameterNotValidException("sort", "Получено: " + sort + " должно быть: ask или desc");
        }
        if (size <= 0) {
            throw new ParameterNotValidException("size", "Размер должен быть больше нуля");
        }

        if (from < 0) {
            throw new ParameterNotValidException("from", "Начало выборки должно быть положительным числом");
        }
        log.info("findAll()");
        return employeeService.findAll(Objects.requireNonNull(SortOrderE.from(sort)), from, size);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO create(@Valid @RequestBody EmployeeDTO employee) {
        log.info("create(employee)");
        return employeeService.create(employee);
    }

    @Override
    @PutMapping
    public EmployeeDTO update(@Valid @RequestBody EmployeeDTO newEmployee) {
        log.info("update(newEmployee)");
        return employeeService.update(newEmployee);
    }

    @Override
    @GetMapping("/{numberId}")
    public Optional<EmployeeDTO> findById(@PathVariable long numberId) {
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
        employeeService.deleteAll();
    }
}