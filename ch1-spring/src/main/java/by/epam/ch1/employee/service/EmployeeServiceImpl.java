package by.epam.ch1.employee.service;

import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.employee.dto.EmployeeDTO;
import by.epam.ch1.employee.model.Employee;
import by.epam.ch1.employee.repository.EmployeeRepositoryImpl;
import by.epam.ch1.exception.EmployeeDoesNotExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static by.epam.ch1.employee.mapper.EmployeeMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepositoryImpl repository;
    private final Comparator<EmployeeDTO>  employeeComparator = Comparator.comparing(EmployeeDTO::getFirstName);

    @Override
    public Collection<EmployeeDTO> findAll(SortOrderE sort, int from, int size) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>(toListDTO(repository.findAll()));
        return employeeDTOS
                .stream()
                .sorted(sort.equals(SortOrderE.ASCENDING) ?
                        employeeComparator : employeeComparator.reversed())
                .skip(from)
                .limit(size)
                .toList();
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employee) {
        employee.setId(getNextId());
        repository.save(toModel(employee));
        log.info("Запись по id = {}", employee.getId());
        return employee;
    }

    @Override
    public EmployeeDTO update(EmployeeDTO newEmployeeDTO) {
        if (!repository.findAll().isEmpty()) {
            Employee oldEmployee = repository.findById(newEmployeeDTO.getId()).orElseThrow(() -> new EmployeeDoesNotExistException("Сотрудник не найден."));
            oldEmployee.setFirstName(newEmployeeDTO.getFirstName());
            oldEmployee.setSecondName(newEmployeeDTO.getSecondName());
            log.info("Обновление id = {}", newEmployeeDTO.getId());
            repository.save(oldEmployee);
            return toDTO(oldEmployee);
        }
        log.info("Ошибка при обновлении");
        throw new EmployeeDoesNotExistException("Сотрудник не найден.");
    }

    @Override
    public Optional<EmployeeDTO> findById(long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeDoesNotExistException("Сотрудник не найден."));
        log.info("Вывод по id = {}", id);
        return Optional.of(toDTO(employee));
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