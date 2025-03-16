package by.epam.ch1.employee.model;

import by.epam.ch1.validator.notnullstring.NottNullString;
import jakarta.validation.constraints.NotBlank;
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
public class Employee {
    private Long id;
    @NottNullString
    private String firstName;
    @NottNullString
    private String secondName;
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime from;
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime to;
}