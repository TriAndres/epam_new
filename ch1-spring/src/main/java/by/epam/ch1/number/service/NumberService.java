package by.epam.ch1.number.service;

import by.epam.ch1.number.model.Number;
import by.epam.ch1.number.model.SortOrderN;

import java.util.Collection;
import java.util.Optional;

public interface NumberService {
    Collection<Number> findAll(SortOrderN sort, int from, int size);

    Number create(Number number);

    Number update(Number number);

    Optional<Number> findById(long id);

    void deleteById(long id);

    void deleteAll();
}