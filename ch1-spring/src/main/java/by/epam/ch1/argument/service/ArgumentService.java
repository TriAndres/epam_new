package by.epam.ch1.argument.service;

import by.epam.ch1.argument.dto.ArgumentDTO;
import by.epam.ch1.argument.model.SortOrderE;

import java.util.Collection;
import java.util.Optional;

public interface ArgumentService {
    Collection<ArgumentDTO> findAll(SortOrderE sort, int from, int size);

    ArgumentDTO create(ArgumentDTO argument);

    ArgumentDTO update(ArgumentDTO newArgument);

    Optional<ArgumentDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
}