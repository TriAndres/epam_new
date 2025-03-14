package by.epam.ch1.number.controller;

import by.epam.ch1.number.model.Number;

import java.util.Collection;
import java.util.Optional;

public interface NumberController {
    Collection<Number> findAll(String sort, int from, int size);

    Number create(Number number);

    Number update(Number number);

    Optional<Number> findById(long numberId);

    void deleteById(long numberId);

    void deleteAll();
}