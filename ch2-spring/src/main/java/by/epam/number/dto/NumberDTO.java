package by.epam.number.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberDTO {
    private Long id;
    private Integer num;
}