package by.epam.number.repository;

import by.epam.number.model.Numbers;

import java.util.List;

public interface NumbersRepository {
    List<Numbers> findAll();
    Numbers save(Numbers numbers);
    Numbers findById(long id);
    void deleteById(long id);
}
