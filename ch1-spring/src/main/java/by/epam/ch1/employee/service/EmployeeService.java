package by.epam.ch1.employee.service;

import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.employee.dto.EmployeeDTO;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    ;Collection<EmployeeDTO> findAll(SortOrderE sort, int from, int size);

    EmployeeDTO create(EmployeeDTO employee);

    EmployeeDTO update(EmployeeDTO newEmployee);

    Optional<EmployeeDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
}