package by.epam.number.mapper;

import by.epam.number.dto.NumbersDTO;
import by.epam.number.model.Numbers;

import java.util.List;

public class NumbersMapper {

    public static NumbersDTO toDTO(Numbers numbers) {
        return NumbersDTO
                .builder()
                .id(numbers.getId())
                .num(numbers.getNum())
                .build();
    }

    public static List<NumbersDTO> toListDTO(List<Numbers> numbers) {
        return numbers
                .stream()
                .map(NumbersMapper::toDTO)
                .toList();
    }

    public static Numbers toModel(NumbersDTO numbersDTO) {
        return Numbers
                .builder()
                .id(numbersDTO.getId())
                .num(numbersDTO.getNum())
                .build();
    }

    public static List<Numbers> toListModel(List<NumbersDTO> numbersDTOS) {
        return numbersDTOS
                .stream()
                .map(NumbersMapper::toModel)
                .toList();
    }
}