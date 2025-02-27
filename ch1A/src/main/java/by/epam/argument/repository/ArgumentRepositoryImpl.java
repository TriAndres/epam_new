package by.epam.argument.repository;

import by.epam.argument.model.Argument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgumentRepositoryImpl implements ArgumentRepository {
    private final Map<Long, Argument> arguments = new HashMap<>();

    @Override
    public List<Argument> findAll() {
        return new ArrayList<>(arguments.values());
    }

    @Override
    public Argument save(Argument argument) {
        return arguments.put(argument.getId(), argument);
    }

    @Override
    public Argument findById(long id) {
        return arguments.get(id);
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