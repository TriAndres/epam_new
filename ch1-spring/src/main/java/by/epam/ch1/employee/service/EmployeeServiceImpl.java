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
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepositoryImpl repository;

    @Override
    public Collection<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(getNextId());
        repository.save(employee);
        log.info("Запись по id = {}", employee.getId());
        return employee;
    }

    @Override
    public Employee update(Employee newEmployee) {
        if (!repository.findAll().isEmpty()) {
            Employee oldEmployee = repository.findById(newEmployee.getId()).orElseThrow(RuntimeException::new);
            oldEmployee.setFirstName(newEmployee.getFirstName());
            oldEmployee.setSecondName(newEmployee.getSecondName());
            log.info("Обновление id = {}", newEmployee.getId());
            repository.save(oldEmployee);
            return oldEmployee;
        }
        throw new RuntimeException();
    }

    @Override
    public Optional<Employee> findById(long id) {
        Employee employee = repository.findById(id).orElseThrow(RuntimeException::new);
        log.info("Вывод по id = {}", id);
        return Optional.of(employee);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
        log.info("Удаление по id = {}", id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
        log.info("Удалить всё.");
    }

    private Long getNextId() {
        long currentMaxId = repository.findAll()
                .stream()
                .mapToLong(Employee::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}