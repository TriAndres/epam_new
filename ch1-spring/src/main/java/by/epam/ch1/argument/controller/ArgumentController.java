package by.epam.ch1.argument.controller;

import by.epam.ch1.argument.dto.ArgumentDTO;
import by.epam.ch1.argument.model.Argument;

import java.util.Collection;
import java.util.Optional;


public interface ArgumentController {

    Collection<ArgumentDTO> findAll(String sort, int from, int size);

    ArgumentDTO create(ArgumentDTO argument);

    ArgumentDTO update(ArgumentDTO newArgument);

    Optional<ArgumentDTO> findById(long numberId);

    void deleteById(long numberId);

    void deleteAll();
}
