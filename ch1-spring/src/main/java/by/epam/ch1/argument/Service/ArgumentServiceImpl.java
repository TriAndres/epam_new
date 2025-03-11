package by.epam.ch1.argument.Service;

import by.epam.ch1.argument.model.Argument;
import by.epam.ch1.argument.repository.ArgumentRepositoryImpl;
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
        return argumentRepository.save(argument);
    }

    @Override
    public Argument update(Argument newArgument) {
        if (!argumentRepository.findAll().isEmpty()) {
            Argument oldArgument = argumentRepository.findById(newArgument.getId()).orElseThrow();
            argumentRepository.save(oldArgument);
            return oldArgument;
        }
        throw new RuntimeException();
    }

    @Override
    public Optional<Argument> findById(long id) {
        return argumentRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        argumentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        argumentRepository.deleteAll();
    }
}
