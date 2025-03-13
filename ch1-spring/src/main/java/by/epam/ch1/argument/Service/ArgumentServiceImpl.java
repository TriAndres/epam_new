package by.epam.ch1.argument.Service;

import by.epam.ch1.argument.model.Argument;
import by.epam.ch1.argument.repository.ArgumentRepositoryImpl;
import by.epam.ch1.exception.ArgumentDoesNotExistException;
import by.epam.ch1.password.model.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArgumentServiceImpl implements ArgumentService {
    private final ArgumentRepositoryImpl argumentRepository;

    @Override
    public Collection<Argument> findAll() {
        return argumentRepository.findAll();
    }

    @Override
    public Argument create(Argument argument) {
        argument.setId(getNextId());
        argumentRepository.save(argument);
        log.info("Запись по id = {}", argument.getId());
        return argument;
    }

    @Override
    public Argument update(Argument newArgument) {
        if (!argumentRepository.findAll().isEmpty()) {
            Argument oldArgument = argumentRepository.findById(newArgument.getId()).orElseThrow(() -> new ArgumentDoesNotExistException("Аргумент не найден"));
            oldArgument.setArgument(newArgument.getArgument());
            log.info("Обновление id = {}", newArgument.getId());
            argumentRepository.save(oldArgument);
            return oldArgument;
        }
        throw new ArgumentDoesNotExistException("Аргумент не найден");
    }

    @Override
    public Optional<Argument> findById(long id) {
        Argument argument = argumentRepository.findById(id).orElseThrow(() -> new ArgumentDoesNotExistException("Аргумент не найден"));
        log.info("Вывод по id = {}", id);
        return Optional.of(argument);
    }

    @Override
    public void deleteById(long id) {
        argumentRepository.deleteById(id);
        log.info("Удаление по id = {}", id);
    }

    @Override
    public void deleteAll() {
        argumentRepository.deleteAll();
        log.info("Удалить всё.");
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