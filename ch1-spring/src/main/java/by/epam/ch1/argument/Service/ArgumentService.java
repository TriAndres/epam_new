package by.epam.ch1.argument.Service;

import by.epam.ch1.argument.model.Argument;
import by.epam.ch1.argument.model.SortOrderE;

import java.util.Collection;
import java.util.Optional;

public interface ArgumentService {
    Collection<Argument> findAll(SortOrderE sort, int from, int size);

    Argument create(Argument argument);

    Argument update(Argument newArgument);

    Optional<Argument> findById(long id);

    void deleteById(long id);

    void deleteAll();
}