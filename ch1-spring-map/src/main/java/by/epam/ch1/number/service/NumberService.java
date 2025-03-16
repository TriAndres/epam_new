package by.epam.ch1.number.service;

import by.epam.ch1.number.dto.NumberDTO;
import by.epam.ch1.number.model.SortOrderN;

import java.util.Collection;
import java.util.Optional;

public interface NumberService {
    Collection<NumberDTO> findAll(SortOrderN sort, int from, int size);

    NumberDTO create(NumberDTO number);

    NumberDTO update(NumberDTO number);

    Optional<NumberDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
}