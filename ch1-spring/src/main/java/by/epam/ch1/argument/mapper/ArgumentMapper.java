package by.epam.ch1.argument.mapper;

import by.epam.ch1.argument.dto.ArgumentDTO;
import by.epam.ch1.argument.model.Argument;

import java.util.ArrayList;
import java.util.List;

public class ArgumentMapper {
    public static ArgumentDTO toDTO(Argument argument) {
        return ArgumentDTO.builder()
                .id(argument.getId())
                .argument(argument.getArgument())
                .build();
    }

    public static List<ArgumentDTO> toListDTO(List<Argument> arguments) {
        return arguments
                .stream()
                .map(ArgumentMapper::toDTO)
                .toList();
    }

    public static Argument toModel(ArgumentDTO argumentDTO) {
        return Argument.builder()
                .id(argumentDTO.getId())
                .argument(argumentDTO.getArgument())
                .build();
    }

    public static List<Argument> toListModel(List<ArgumentDTO> argumentDTO) {
        List<Argument> list = new ArrayList<>();
        for (ArgumentDTO dto : argumentDTO) {
            list.add(toModel(dto));
        }
        return list;
    }
}
