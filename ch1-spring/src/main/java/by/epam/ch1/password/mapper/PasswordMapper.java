package by.epam.ch1.password.mapper;

import by.epam.ch1.password.dto.PasswordDTO;
import by.epam.ch1.password.model.Password;

import java.util.ArrayList;
import java.util.List;

public class PasswordMapper {
    public static PasswordDTO toDTO(Password password) {
        return PasswordDTO
                .builder()
                .id(password.getId())
                .login(password.getLogin())
                .password(password.getPassword())
                .registration(password.getRegistration())
                .registrationDateTime(password.getRegistrationDateTime())
                .employeeId(password.getEmployeeId())
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
                .registration(passwordDTO.getRegistration())
                .registrationDateTime(passwordDTO.getRegistrationDateTime())
                .employeeId(passwordDTO.getEmployeeId())
                .build();
    }

    public static List<Password> toListModel(List<PasswordDTO> passwordDTOS) {
        List<Password> list = new ArrayList<>();
        for (PasswordDTO dto : passwordDTOS) {
            list.add(toModel(dto));
        }
        return list;
    }
}