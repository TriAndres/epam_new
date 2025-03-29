package by.epam.password.service;

import by.epam.password.dto.PasswordDTO;

import java.util.Collection;
import java.util.Optional;

public interface PasswordService {
    Collection<PasswordDTO> passwordFindAll();

    PasswordDTO passwordCreate(PasswordDTO passwordDTO);

    PasswordDTO passwordUpdate(PasswordDTO passwordDTO);

    Optional<PasswordDTO> passwordFindById(long id);

    void passwordDeleteById(long id);
}
