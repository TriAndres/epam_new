package by.epam.ch1.password.repository;

import by.epam.ch1.password.model.Password;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PasswordRepositoryImpl implements PasswordRepository {
    private final Map<Long, Password> passwords = new HashMap<>();

    @Override
    public List<Password> findAll() {
        return new ArrayList<>(passwords.values());
    }

    @Override
    public Password save(Password password) {
        return passwords.put(password.getId(), password);
    }

    @Override
    public Optional<Password> findById(long id) {
        return Optional.ofNullable(passwords.get(id));
    }

    @Override
    public void deleteById(long id) {
        passwords.remove(id);
    }

    @Override
    public void deleteAll() {
        passwords.clear();
    }
}