package by.epam.ch1.password.repository;

import by.epam.ch1.password.model.Password;

import java.util.Collection;
import java.util.Optional;

public interface PasswordRepository {
    Collection<Password> findAll();

    Password save(Password password);

    Optional<Password> findById(long id);

    void deleteById(long id);

    void deleteAll();
}
