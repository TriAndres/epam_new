package by.epam.ch1.password.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Password {
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 5, message = "login min = 5")
    private String login;
    @NotNull
    @NotBlank
    @Size(min = 5, message = "password min = 5")
    private String password;
    private Boolean registration;
    private LocalDateTime registrationDateTime;
    private Long employeeId;
}