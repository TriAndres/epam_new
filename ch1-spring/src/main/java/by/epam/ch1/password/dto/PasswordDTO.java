package by.epam.ch1.password.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PasswordDTO {
    private Long id;
    private String login;
    private String password;
    private Boolean registration;
    private LocalDateTime registrationDateTime;
    private Long employeeId;
}