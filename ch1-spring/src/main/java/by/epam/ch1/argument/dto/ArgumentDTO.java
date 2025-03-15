package by.epam.ch1.argument.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArgumentDTO {
    private Long id;
    private String argument;
}