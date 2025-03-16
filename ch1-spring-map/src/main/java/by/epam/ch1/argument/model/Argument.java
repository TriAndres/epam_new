package by.epam.ch1.argument.model;

import by.epam.ch1.validator.notnullstring.NottNullString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Argument {
    private Long id;
    @NottNullString
    private String argument;
}