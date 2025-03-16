package by.epam.ch1.number.mapper;

import by.epam.ch1.number.dto.NumberDTO;
import by.epam.ch1.number.model.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberMapper {
    public static NumberDTO toDTO(Number number) {
        return NumberDTO
                .builder()
                .id(number.getId())
                .num(number.getNum())
                .build();
    }

    public static List<NumberDTO> toListDTO(List<Number> numbers) {
        return numbers
                .stream()
                .map(NumberMapper::toDTO)
                .toList();
    }

    public static Number toModel(NumberDTO numberDTO) {
        return Number
                .builder()
                .id(numberDTO.getId())
                .num(numberDTO.getNum())
                .build();
    }

    public static List<Number> toListModel(List<NumberDTO> numberDTOS) {
        List<Number> list = new ArrayList<>();
        for (NumberDTO dto : numberDTOS) {
            list.add(toModel(dto));
        }
        return list;
    }
}