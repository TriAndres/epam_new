package by.epam.ch1.argument.controller;

import by.epam.ch1.argument.model.Argument;

import java.util.Collection;
import java.util.Optional;


public interface ArgumentController {
    Collection<Argument> findAll();

    Argument create(Argument argument);

    Argument update(Argument newArgument);

    Optional<Argument> findById(long numberId);

    void deleteById(long numberId);

    void deleteAll();
}
