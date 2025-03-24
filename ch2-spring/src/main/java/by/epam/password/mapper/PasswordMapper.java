package by.epam.password.mapper;

import by.epam.password.dto.PasswordDTO;
import by.epam.password.model.Password;

import java.util.List;

public class PasswordMapper {
    public static PasswordDTO toDTO(Password password) {
        return PasswordDTO
                .builder()
                .id(password.getId())
                .login(password.getLogin())
                .password(password.getPassword())
                .firstName(password.getFirstName())
                .secondName(password.getSecondName())
                .email(password.getEmail())
                .registration(password.getRegistration())
                .dataRegistration(password.getDataRegistration())
                .build();
    }

    public static List<PasswordDTO> toListDTO(List<Password> passwords) {
        return passwords
                .stream()
                .map(PasswordMapper::toDTO)
                .toList();
    }

    public static Password toModel(PasswordDTO passwordDTO) {
        return Password
                .builder()
                .id(passwordDTO.getId())
                .login(passwordDTO.getLogin())
                .password(passwordDTO.getPassword())
                .firstName(passwordDTO.getFirstName())
                .secondName(passwordDTO.getSecondName())
                .email(passwordDTO.getEmail())
                .registration(passwordDTO.getRegistration())
                .dataRegistration(passwordDTO.getDataRegistration())
                .dataRegistration(passwordDTO.getDataRegistration())
                .build();
    }

    public static List<Password> toListModel(List<PasswordDTO> passwordDTOS) {
        return passwordDTOS
                .stream()
                .map(PasswordMapper::toModel)
                .toList();
    }
}