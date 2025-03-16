package by.epam.ch1.employee.controller;

import by.epam.ch1.employee.dto.EmployeeDTO;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeController {
    Collection<EmployeeDTO> findAll(String sort, int from, int size);

    EmployeeDTO create(EmployeeDTO employee);

    EmployeeDTO update(EmployeeDTO newEmployee);

    Optional<EmployeeDTO> findById(long numberId);

    void deleteById(long numberId);

    void deleteAll();
}