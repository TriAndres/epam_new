package by.epam.password.service;

import by.epam.exception.PasswordDoesNotExistException;
import by.epam.password.dto.PasswordDTO;
import by.epam.password.model.Password;
import by.epam.password.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static by.epam.password.mapper.PasswordMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class PasswordServiceImpl implements PasswordService {
    private PasswordRepository passwordRepository;

    @Override
    public Collection<PasswordDTO> findAll() {
        return new ArrayList<>(toListDTO(passwordRepository.findAll()));
    }

    @Override
    public PasswordDTO passwordCreate(PasswordDTO passwordDTO) {
        passwordDTO.setDataRegistration(LocalDateTime.now());
        passwordRepository.save(toModel(passwordDTO));
        log.info("Запись по id = {}", passwordDTO.getId());
        return passwordDTO;
    }

    @Override
    public PasswordDTO passwordUpdate(long id, PasswordDTO passwordDTO) {
        return null;
    }

    @Override
    public PasswordDTO passwordUpdate2(PasswordDTO newPasswordDTO) {
        Password password = passwordRepository.findById(newPasswordDTO.getId()).orElseThrow(() -> new PasswordDoesNotExistException("Сотрудник не найден."));
        password.setLogin(newPasswordDTO.getLogin());
        password.setPassword(newPasswordDTO.getPassword());
        password.setFirstName(newPasswordDTO.getFirstName());
        password.setSecondName(newPasswordDTO.getSecondName());
        password.setEmail(newPasswordDTO.getEmail());
        return toDTO(password);
    }

    @Override
    public Optional<PasswordDTO> passwordFindById(long id) {
        return Optional.of(toDTO(passwordRepository.findById(id).orElseThrow(() -> new PasswordDoesNotExistException("Пароль не найден."))));
    }

    @Override
    public void passwordDeleteAll(long id) {
        passwordRepository.delete(passwordRepository.findById(id).orElseThrow(() -> new PasswordDoesNotExistException("Пароль не найден.")));
    }
}