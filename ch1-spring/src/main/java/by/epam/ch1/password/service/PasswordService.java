package by.epam.ch1.password.service;

import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.repository.PasswordRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordRepositoryImpl passwordRepository;

    public Collection<Password> findAll() {
        return passwordRepository.findAll();
    }

    public Password create(Password password) {
        return passwordRepository.save(password);
    }

    public Password update(Password password) {
        return passwordRepository.save(password);
    }

    public Optional<Password> findById(long id) {
        return passwordRepository.findById(id);
    }

    public void deleteById(long id) {
        passwordRepository.deleteById(id);
    }

    public void deleteAll() {
        passwordRepository.findAll();
    }
}
