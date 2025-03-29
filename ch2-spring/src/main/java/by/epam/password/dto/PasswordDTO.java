package by.epam.password.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordDTO {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String registration;
    private String dataRegistration;
}