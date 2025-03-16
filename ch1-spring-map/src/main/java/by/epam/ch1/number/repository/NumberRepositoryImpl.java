package by.epam.ch1.number.repository;

import by.epam.ch1.number.model.Number;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
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
    public Optional<Number> findById(long id) {
        return Optional.ofNullable(numbers.get(id));
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