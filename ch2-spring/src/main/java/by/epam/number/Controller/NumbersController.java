package by.epam.number.Controller;

import by.epam.number.dto.NumbersDTO;

import java.util.Collection;
import java.util.Optional;

public interface NumbersController {
    Collection<NumbersDTO> numbersFindAll();

    NumbersDTO numbersCreate(NumbersDTO numbersDTO);

    NumbersDTO numbersUpdate(NumbersDTO newNumbersDTO);

    Optional<NumbersDTO> numbersFindById(long id);

    void numbersDeleteById(long id);
}
