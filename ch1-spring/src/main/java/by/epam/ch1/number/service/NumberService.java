package by.epam.ch1.number.service;

import by.epam.ch1.number.model.Number;
import by.epam.ch1.number.repository.NumberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NumberService {
    private final NumberRepositoryImpl numberRepository;

    public Collection<Number> findAll() {
        return numberRepository.findAll();
    }

    public Number create(Number number) {
        number.setId(getNextId());
        return numberRepository.save(number);
    }

    public Number update(Number number) {
        return numberRepository.save(number);
    }

    public Optional<Number> findById(long id) {
        return numberRepository.findById(id);
    }

    public void deleteById(long id) {
        numberRepository.deleteById(id);
    }

    public void deleteAll() {
        numberRepository.deleteAll();
    }

    private Long getNextId() {
        long currentMaxId = numberRepository.findAll()
                .stream()
                .mapToLong(Number::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}