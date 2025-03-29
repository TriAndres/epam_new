package by.epam.password.service;

import by.epam.exception.PasswordDoesNotExistException;
import by.epam.password.dto.PasswordDTO;
import by.epam.password.model.Password;
import by.epam.password.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static by.epam.password.mapper.PasswordMapper.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class PasswordServiceImpl implements PasswordService {

    private final PasswordRepository passwordRepository;

    @Override
    public List<PasswordDTO> passwordFindAll() {
        return toListDTO(passwordRepository.findAll());
    }

    @Override
    public PasswordDTO passwordCreate(PasswordDTO passwordDTO) {
        Password employee = toModel(passwordDTO);
        employee.setRegistration("false");
        employee.setDataRegistration(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
        Password savedEmployee = passwordRepository.save(employee);
        return toDTO(savedEmployee);
    }

    @Override
    public PasswordDTO passwordUpdate(PasswordDTO newPasswordDTO) {
        try {
            Password oldPassword = passwordRepository
                    .findById(newPasswordDTO.getId())
                    .orElseThrow();
            oldPassword.setLogin(newPasswordDTO.getLogin());
            oldPassword.setPassword(newPasswordDTO.getPassword());
            oldPassword.setFirstName(newPasswordDTO.getFirstName());
            oldPassword.setSecondName(newPasswordDTO.getSecondName());
            oldPassword.setEmail(newPasswordDTO.getEmail());
            passwordRepository.save(oldPassword);
            return toDTO(oldPassword);
        } catch (Exception e) {
            throw new PasswordDoesNotExistException("Введите правильно:id, логин, пароль, фамилию, имя и логин");
        }
    }


    @Override
    public Optional<PasswordDTO> passwordFindById(long id) {
        return Optional.of(toDTO(passwordRepository
                .findById(id)
                .orElseThrow(() -> new PasswordDoesNotExistException("Паспорт сотрудника не найден."))));
    }

    @Override
    public void passwordDeleteById(long id) {
        passwordRepository.deleteById(id);
    }
}