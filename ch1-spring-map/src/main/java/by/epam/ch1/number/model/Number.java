package by.epam.ch1.number.model;

import by.epam.ch1.validator.notnulllong.NottNullLong;
import by.epam.ch1.validator.notnullstring.NottNullString;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Number {
    private Long id;
    @NottNullLong
    private Integer num;
}