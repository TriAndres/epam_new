package by.epam.ch1.employee.service;

import by.epam.ch1.employee.model.Employee;
import by.epam.ch1.employee.repository.EmployeeRepositoryImpl;
import by.epam.ch1.exception.EmployeeDoesNotExistException;
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
            Employee oldEmployee = repository.findById(newEmployee.getId()).orElseThrow(() -> new EmployeeDoesNotExistException("Сотрудник не найден."));
            oldEmployee.setFirstName(newEmployee.getFirstName());
            oldEmployee.setSecondName(newEmployee.getSecondName());
            log.info("Обновление id = {}", newEmployee.getId());
            repository.save(oldEmployee);
            return oldEmployee;
        }
        throw new EmployeeDoesNotExistException("Сотрудник не найден.");
    }

    @Override
    public Optional<Employee> findById(long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeDoesNotExistException("Сотрудник не найден."));
        log.info("Вывод по id = {}", id);
        return Optional.of(employee);
    }

    @Override
    public void deleteById(long id) {
        log.info("Удаление по id = {}", id);
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Удалить всё.");
        repository.deleteAll();
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