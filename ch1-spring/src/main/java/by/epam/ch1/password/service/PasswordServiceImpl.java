package by.epam.ch1.password.service;

import by.epam.ch1.exception.PasswordDoesNotExistException;
import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.model.SortOrderP;
import by.epam.ch1.password.repository.PasswordRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PasswordServiceImpl implements PasswordService {
    private final PasswordRepositoryImpl passwordRepository;
    private final Comparator<Password> passwordComparator = Comparator.comparing(Password::getRegistrationDateTime);

    @Override
    public Collection<Password> findAll(SortOrderP sort, int from, int size) {
        return passwordRepository.findAll()
                .stream()
                .sorted(sort.equals(SortOrderP.ASCENDING) ?
                        passwordComparator : passwordComparator.reversed())
                .skip(from)
                .limit(size)
                .toList();
    }

    @Override
    public Password create(Password password) {
        password.setId(getNextId());
        passwordRepository.save(password);
        log.info("Запись по id = {}", password.getId());
        return password;
    }

    @Override
    public Password update(Password newPassword) {
        if (!passwordRepository.findAll().isEmpty()) {
            Password oldPassword = passwordRepository.findById(newPassword.getId()).orElseThrow(() -> new PasswordDoesNotExistException("Пароль не найден."));
            oldPassword.setLogin(newPassword.getLogin());
            oldPassword.setPassword(newPassword.getPassword());
            log.info("Обновление id = {}", newPassword.getId());
            passwordRepository.save(oldPassword);
        }
        throw new PasswordDoesNotExistException("Пароль не найден.");
    }

    @Override
    public Optional<Password> findById(long id) {
        Password password = passwordRepository.findById(id).orElseThrow();
        log.info("Вывод по id = {}", id);
        return Optional.of(password);
    }

    @Override
    public void deleteById(long id) {
        log.info("Удаление по id = {}", id);
        passwordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Удалить всё.");
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