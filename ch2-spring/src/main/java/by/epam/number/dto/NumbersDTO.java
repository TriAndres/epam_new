package by.epam.number.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumbersDTO {
    private Long id;
    private Integer num;
}