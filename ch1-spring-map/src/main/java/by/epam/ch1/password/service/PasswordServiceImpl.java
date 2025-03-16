package by.epam.ch1.password.service;

import by.epam.ch1.exception.PasswordDoesNotExistException;
import by.epam.ch1.password.dto.PasswordDTO;
import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.model.SortOrderP;
import by.epam.ch1.password.repository.PasswordRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static by.epam.ch1.password.mapper.PasswordMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class PasswordServiceImpl implements PasswordService {
    private final PasswordRepositoryImpl passwordRepository;
    private final Comparator<PasswordDTO> passwordComparator = Comparator.comparing(PasswordDTO::getRegistrationDateTime);

    @Override
    public Collection<PasswordDTO> findAll(SortOrderP sort, int from, int size) {
        List<PasswordDTO> passwordDTOS = new ArrayList<>(toListDTO(passwordRepository.findAll()));
        return passwordDTOS
                .stream()
                .sorted(sort.equals(SortOrderP.ASCENDING) ?
                        passwordComparator : passwordComparator.reversed())
                .skip(from)
                .limit(size)
                .toList();
    }

    @Override
    public PasswordDTO create(PasswordDTO password) {
        password.setId(getNextId());
        password.setRegistrationDateTime(LocalDateTime.now());
        passwordRepository.save(toModel(password));
        log.info("Запись по id = {}", password.getId());
        return password;
    }

    @Override
    public PasswordDTO update(PasswordDTO newPassword) {
        if (!passwordRepository.findAll().isEmpty()) {
            Password oldPassword = passwordRepository.findById(newPassword.getId()).orElseThrow(() -> new PasswordDoesNotExistException("Пароль не найден."));
            oldPassword.setLogin(newPassword.getLogin());
            oldPassword.setPassword(newPassword.getPassword());
            log.info("Обновление id = {}", newPassword.getId());
            passwordRepository.save(oldPassword);
            return toDTO(oldPassword);
        }
        log.info("Ошибка при обновлении");
        throw new PasswordDoesNotExistException("Пароль не найден.");
    }

    @Override
    public Optional<PasswordDTO> findById(long id) {
        Password password = passwordRepository.findById(id).orElseThrow();
        log.info("Вывод по id = {}", id);
        return Optional.of(toDTO(password));
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