package by.epam.ch1.password.service;

import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.repository.PasswordRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {
    private final PasswordRepositoryImpl passwordRepository;

    @Override
    public Collection<Password> findAll() {
        return passwordRepository.findAll();
    }

    @Override
    public Password create(Password password) {
        password.setId(getNextId());
        return passwordRepository.save(password);
    }

    @Override
    public Password update(Password password) {
        return passwordRepository.save(password);
    }

    @Override
    public Optional<Password> findById(long id) {
        return passwordRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        passwordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        passwordRepository.findAll();
    }

    private Long getNextId() {
        long currentMaxId = passwordRepository.findAll()
                .stream()
                .mapToLong(Password::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}