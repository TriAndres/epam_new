package by.epam.argument.repository;

import by.epam.argument.model.Argument;

import java.util.List;

public interface ArgumentRepository {
    List<Argument> findAll();

    Argument save(Argument argument);

    Argument findById(long id);

    void deleteById(long id);

    void deleteAll();
}