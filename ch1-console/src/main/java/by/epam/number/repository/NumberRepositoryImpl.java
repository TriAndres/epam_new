package by.epam.number.repository;

import by.epam.number.model.Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberRepositoryImpl implements NumberRepository {
    private final Map<Long, Number> numbers = new HashMap<>();

    @Override
    public List<Number> findAll() {
        return new ArrayList<>(numbers.values());
    }

    @Override
    public Number save(Number number) {
        return numbers.put(number.getId(), number);
    }

    @Override
    public Number findById(long id) {
        return numbers.get(id);
    }

    @Override
    public void deleteById(long id) {
        numbers.remove(id);
    }

    @Override
    public void deleteAll() {
        numbers.clear();
    }
}