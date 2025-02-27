package by.epam.password.repository;

import by.epam.password.model.Password;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Password findById(long id) {
        return passwords.get(id);
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
