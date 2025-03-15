package by.epam.ch1.password.controller;

import by.epam.ch1.password.dto.PasswordDTO;

import java.util.Collection;
import java.util.Optional;

public interface PasswordController {
    Collection<PasswordDTO> findAll(String sort, int from, int size);

    PasswordDTO create(PasswordDTO password);

    PasswordDTO update(PasswordDTO newPassword);

    Optional<PasswordDTO> findById(long passwordId);

    void deleteById(long passwordId);

    void deleteAll();
}