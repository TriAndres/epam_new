package by.epam.ch1.argument.service;

import by.epam.ch1.argument.dto.ArgumentDTO;
import by.epam.ch1.argument.model.Argument;
import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.argument.repository.ArgumentRepositoryImpl;
import by.epam.ch1.exception.ArgumentDoesNotExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static by.epam.ch1.argument.mapper.ArgumentMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArgumentServiceImpl implements ArgumentService {
    private final ArgumentRepositoryImpl argumentRepository;
    private final Comparator<ArgumentDTO> argumenDateComparator = Comparator.comparing(ArgumentDTO::getArgument);

    @Override
    public Collection<ArgumentDTO> findAll(SortOrderE sort, int from, int size) {
        List<ArgumentDTO> argumentDTOS = new ArrayList<>(toListDTO(argumentRepository.findAll()));
        return argumentDTOS
                .stream()
                .sorted(sort.equals(SortOrderE.ASCENDING) ?
                        argumenDateComparator : argumenDateComparator.reversed())
                .skip(from)
                .limit(size)
                .toList();
    }

    @Override
    public ArgumentDTO create(ArgumentDTO argument) {
        argument.setId(getNextId());
        argumentRepository.save(toModel(argument));
        log.info("Запись по id = {}", argument.getId());
        return argument;
    }

    @Override
    public ArgumentDTO update(ArgumentDTO newArgument) {
        if (!argumentRepository.findAll().isEmpty()) {
            Argument oldArgument = argumentRepository.findById(newArgument.getId()).orElseThrow(() -> new ArgumentDoesNotExistException("Аргумент не найден"));
            oldArgument.setArgument(newArgument.getArgument());
            log.info("Обновление id = {}", newArgument.getId());
            argumentRepository.save(oldArgument);
            return toDTO(oldArgument);
        }
        log.info("Ошибка при обновлении");
        throw new ArgumentDoesNotExistException("Аргумент не найден");
    }

    @Override
    public Optional<ArgumentDTO> findById(long id) {
        Argument argument = argumentRepository.findById(id).orElseThrow(() -> new ArgumentDoesNotExistException("Аргумент не найден"));
        log.info("Вывод по id = {}", id);
        return Optional.of(toDTO(argument));
    }

    @Override
    public void deleteById(long id) {
        log.info("Удаление по id = {}", id);
        argumentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Удалить всё.");
        argumentRepository.deleteAll();
    }

    private Long getNextId() {
        long currentMaxId = argumentRepository.findAll()
                .stream()
                .mapToLong(Argument::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}