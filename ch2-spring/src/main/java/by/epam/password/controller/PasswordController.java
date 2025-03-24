package by.epam.password.controller;

import by.epam.password.dto.PasswordDTO;

import java.util.Collection;
import java.util.Optional;

public interface PasswordController {
    Collection<PasswordDTO> findAll();
    PasswordDTO passwordCreate(PasswordDTO passwordDTO);
    PasswordDTO passwordUpdate(long id, PasswordDTO passwordDTO);
    PasswordDTO passwordUpdate2(PasswordDTO passwordDTO);
    Optional<PasswordDTO> passwordFindById(long id);
    void passwordDeleteId(long id);
}