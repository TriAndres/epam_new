package by.epam.ch1.number.controller;

import by.epam.ch1.number.model.Number;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;

public interface NumberController {
    Collection<Number> findAll();

    Number create(Number number);

    Number update(Number number);

    Optional<Number> findById(@PathVariable long numberId);

    void deleteById(@PathVariable long numberId);

    void deleteAll();
}