package by.epam.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String registration;
    private String dataRegistration;
}