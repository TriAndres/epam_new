package by.epam.ch1.number.service;

import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.exception.NumberDoesNotExistException;
import by.epam.ch1.number.dto.NumberDTO;
import by.epam.ch1.number.model.Number;
import by.epam.ch1.number.model.SortOrderN;
import by.epam.ch1.number.repository.NumberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static by.epam.ch1.number.mapper.NumberMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumberServiceImpl implements NumberService {
    private final NumberRepositoryImpl numberRepository;
    private final Comparator<NumberDTO> numberComparator = Comparator.comparing(NumberDTO::getNum);

    @Override
    public Collection<NumberDTO> findAll(SortOrderN sort, int from, int size) {
        List<NumberDTO> numberDTOS = new ArrayList<>(toListDTO(numberRepository.findAll()));
        return numberDTOS
                .stream()
                .sorted(sort.equals(SortOrderN.ASCENDING) ?
                        numberComparator : numberComparator.reversed())
                .skip(from)
                .limit(size)
                .toList();
    }

    @Override
    public NumberDTO create(NumberDTO number) {
        number.setId(getNextId());
        numberRepository.save(toModel(number));
        log.info("Запись по id = {}", number.getId());
        return number;
    }

    @Override
    public NumberDTO update(NumberDTO newNumber) {
        if (!numberRepository.findAll().isEmpty()) {
            Number oldNumber = numberRepository.findById(newNumber.getId()).orElseThrow(() -> new NumberDoesNotExistException("Цифра не найдена."));
            oldNumber.setNum(newNumber.getNum());
            log.info("Обновление id = {}", newNumber.getId());
            numberRepository.save(oldNumber);
            return toDTO(oldNumber);
        }
        log.info("Ошибка при обновлении");
        throw new NumberDoesNotExistException("Цифра не найдена.");
    }

    @Override
    public Optional<NumberDTO> findById(long id) {
        Number number = numberRepository.findById(id).orElseThrow(() -> new NumberDoesNotExistException("Цифра не найдена."));
        log.info("Вывод по id = {}", id);
        return Optional.of(toDTO(number));
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