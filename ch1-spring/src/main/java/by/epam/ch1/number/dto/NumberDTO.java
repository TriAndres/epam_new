package by.epam.ch1.number.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberDTO {
    private Long id;
    private Integer num;
}