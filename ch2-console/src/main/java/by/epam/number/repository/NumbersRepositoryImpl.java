package by.epam.number.repository;



import by.epam.number.model.Numbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbersRepositoryImpl implements NumbersRepository {
    private final Map<Long, Numbers> numbers = new HashMap<>();


    @Override
    public List<Numbers> findAll() {
        return numbers.values().stream().toList();
    }

    @Override
    public Numbers save(Numbers number) {
        return numbers.put(number.getId(), number);
    }

    @Override
    public Numbers findById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}