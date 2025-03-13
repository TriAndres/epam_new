package by.epam.ch1.number.service;

import by.epam.ch1.exception.ArgumentDoesNotExistException;
import by.epam.ch1.exception.NumberDoesNotExistException;
import by.epam.ch1.number.model.Number;
import by.epam.ch1.number.repository.NumberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumberServiceImpl implements NumberService {
    private final NumberRepositoryImpl numberRepository;

    @Override
    public Collection<Number> findAll() {
        return numberRepository.findAll();
    }

    @Override
    public Number create(Number number) {
        number.setId(getNextId());
        numberRepository.save(number);
        log.info("Запись по id = {}", number.getId());
        return number;
    }

    @Override
    public Number update(Number newNumber) {
        if (!numberRepository.findAll().isEmpty()) {
            Number oldNumber = numberRepository.findById(newNumber.getId()).orElseThrow(() -> new NumberDoesNotExistException("Цифра не найдена."));
            oldNumber.setNum(newNumber.getNum());
            log.info("Обновление id = {}", newNumber.getId());
            numberRepository.save(oldNumber);
            return oldNumber;
        }
        throw new NumberDoesNotExistException("Цифра не найдена.");
    }

    @Override
    public Optional<Number> findById(long id) {
        Number number = numberRepository.findById(id).orElseThrow(() -> new NumberDoesNotExistException("Цифра не найдена."));
        log.info("Вывод по id = {}", id);
        return Optional.of(number);
    }

    @Override
    public void deleteById(long id) {
        log.info("Удаление по id = {}", id);
        numberRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Удалить всё.");
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