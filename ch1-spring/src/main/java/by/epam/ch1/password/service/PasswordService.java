package by.epam.ch1.password.service;

import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.model.SortOrderP;

import java.util.Collection;
import java.util.Optional;

public interface PasswordService {
    Collection<Password> findAll(SortOrderP sort, int from, int size);

    Password create(Password password);

    Password update(Password password);

    Optional<Password> findById(long id);

    void deleteById(long id);

    void deleteAll();
}