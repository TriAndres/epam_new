package by.epam.number.repository;

import by.epam.number.model.Number;

import java.util.List;

public interface NumberRepository {
    List<Number> findAll();

    Number save(Number number);

    Number findById(long id);

    void deleteById(long id);

    void deleteAll();
}