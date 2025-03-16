package by.epam.ch1.password.repository;

import by.epam.ch1.password.model.Password;

import java.util.List;
import java.util.Optional;

public interface PasswordRepository {
    List<Password> findAll();

    Password save(Password password);

    Optional<Password> findById(long id);

    void deleteById(long id);

    void deleteAll();
}