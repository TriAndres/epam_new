package by.epam.password.repository;

import by.epam.password.model.Password;

import java.util.List;

public interface PasswordRepository {
    List<Password> findAll();

    Password save(Password password);

    Password findById(long id);

    void deleteById(long id);

    void deleteAll();
}
