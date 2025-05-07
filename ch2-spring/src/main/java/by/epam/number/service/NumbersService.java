package by.epam.number.service;

import by.epam.number.dto.NumbersDTO;

import java.util.Collection;
import java.util.Optional;

public interface NumbersService {
    Collection<NumbersDTO> numbersFindAll();

    NumbersDTO numbersCreate(NumbersDTO numbersDTO);

    NumbersDTO numbersUpdate(NumbersDTO newNumbersDTO);

    Optional<NumbersDTO> numbersFindById(long id);

    void numbersDeleteById(long id);

    String taskA1();

    String taskA2();

    String taskA3();

    String taskA4();

    String taskA5();

    String taskA6();

    String taskA7();

    String taskA8();
}