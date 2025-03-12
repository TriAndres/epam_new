package by.epam.ch1.argument.repository;

import by.epam.ch1.argument.model.Argument;

import java.util.Collection;
import java.util.Optional;

public interface ArgumentRepository {
    Collection<Argument> findAll();

    Argument save(Argument argument);

    Optional<Argument> findById(long id);

    void deleteById(long id);

    void deleteAll();
}