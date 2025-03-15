package by.epam.ch1.password.service;

import by.epam.ch1.password.dto.PasswordDTO;
import by.epam.ch1.password.model.SortOrderP;

import java.util.Collection;
import java.util.Optional;

public interface PasswordService {
    Collection<PasswordDTO> findAll(SortOrderP sort, int from, int size);

    PasswordDTO create(PasswordDTO password);

    PasswordDTO update(PasswordDTO password);

    Optional<PasswordDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
}