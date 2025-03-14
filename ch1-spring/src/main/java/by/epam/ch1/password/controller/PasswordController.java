package by.epam.ch1.password.controller;

import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.model.SortOrderP;

import java.util.Collection;
import java.util.Optional;

public interface PasswordController {
    Collection<Password> findAll(String sort, int from, int size);

    Password create(Password password);

    Password update(Password newPassword);

    Optional<Password> findById(long passwordId);

    void deleteById(long passwordId);

    void deleteAll();
}