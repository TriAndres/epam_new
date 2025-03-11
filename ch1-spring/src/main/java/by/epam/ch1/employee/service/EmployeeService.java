package by.epam.ch1.employee.service;

import by.epam.ch1.employee.model.Employee;
import by.epam.ch1.employee.repository.EmployeeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepositoryImpl repository;

    public Collection<Employee> findAll() {
        return repository.findAll();
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Employee newEmployee) {
        if (!repository.findAll().isEmpty()) {
            Employee oldEmployee = repository.findById(newEmployee.getId()).orElseThrow();
            return repository.save(oldEmployee);
        }
        throw new RuntimeException();
    }

    public Optional<Employee> findById(long id) {
        Employee employee = repository.findById(id).orElseThrow();
        return Optional.of(employee);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}