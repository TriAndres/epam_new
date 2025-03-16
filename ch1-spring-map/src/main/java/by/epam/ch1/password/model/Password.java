package by.epam.ch1.password.model;

import by.epam.ch1.validator.notnullstring.NottNullString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Password {
    private Long id;
    @NottNullString
    @Size(min = 5, message = "login min = 5")
    private String login;
    @NottNullString
    @Size(min = 5, message = "password min = 5")
    private String password;
    private Boolean registration;
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime registrationDateTime;
    private Long employeeId;
}