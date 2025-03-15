package by.epam.ch1.number.repository;

import by.epam.ch1.number.model.Number;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface NumberRepository {
    List<Number> findAll();

    Number save(Number number);

    Optional<Number> findById(long id);

    void deleteById(long id);

    void deleteAll();
}