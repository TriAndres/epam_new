package by.epam.password.controller;

import by.epam.password.dto.PasswordDTO;

import java.util.Collection;
import java.util.Optional;

public interface PasswordController {
    Collection<PasswordDTO> passwordFindAll();
    PasswordDTO passwordCreate(PasswordDTO passwordDTO);
    PasswordDTO passwordUpdate(PasswordDTO passwordDTO);
    Optional<PasswordDTO> passwordFindById(long id);
    void passwordDeleteById(long id);
}