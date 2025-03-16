package by.epam.ch1.employee.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String SecondName;
    private LocalDateTime from;
    private LocalDateTime to;
}