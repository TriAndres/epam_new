package by.epam.ch1.argument.repository;

import by.epam.ch1.argument.model.Argument;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ArgumentRepositoryImpl implements ArgumentRepository {
    private Map<Long, Argument> arguments = new HashMap<>();
    @Override
    public Collection<Argument> findAll() {
        return arguments.values();
    }

    @Override
    public Argument save(Argument argument) {
        return arguments.put(argument.getId(), argument);
    }

    @Override
    public Optional<Argument> findById(long id) {
        return Optional.ofNullable(arguments.get(id));
    }

    @Override
    public void deleteById(long id) {
        arguments.remove(id);
    }

    @Override
    public void deleteAll() {
        arguments.clear();
    }
}