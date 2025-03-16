package by.epam.ch1.number.controller;

import by.epam.ch1.number.dto.NumberDTO;

import java.util.Collection;
import java.util.Optional;

public interface NumberController {
    Collection<NumberDTO> findAll(String sort, int from, int size);

    NumberDTO create(NumberDTO number);

    NumberDTO update(NumberDTO number);

    Optional<NumberDTO> findById(long numberId);

    void deleteById(long numberId);

    void deleteAll();
}