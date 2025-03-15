package by.epam.ch1.argument.controller;

import by.epam.ch1.argument.service.ArgumentServiceImpl;
import by.epam.ch1.argument.dto.ArgumentDTO;
import by.epam.ch1.argument.model.SortOrderE;
import by.epam.ch1.exception.ParameterNotValidException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/argument")
@Slf4j
public class ArgumentControllerImpl implements ArgumentController {
    private final ArgumentServiceImpl argumentService;

    @Override
    @GetMapping
    public Collection<ArgumentDTO> findAll(@RequestParam(defaultValue = "desk") String sort,
                                           @RequestParam(defaultValue = "0") int from,
                                           @RequestParam(defaultValue = "10") int size) {
        SortOrderE sortOrder = SortOrderE.from(sort);
        if (sortOrder == null) {
            throw new ParameterNotValidException("sort", "Получено: " + sort + " должно быть: ask или desc");
        }
        if (size <= 0) {
            throw new ParameterNotValidException("size", "Размер должен быть больше нуля");
        }

        if (from < 0) {
            throw new ParameterNotValidException("from", "Начало выборки должно быть положительным числом");
        }
        log.info("findAll()");
        return argumentService.findAll(Objects.requireNonNull(SortOrderE.from(sort)), from, size);
    }


    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArgumentDTO create(@Valid @RequestBody ArgumentDTO argument) {
        log.info("create(argument)");
        return argumentService.create(argument);
    }

    @Override
    @PutMapping
    public ArgumentDTO update(@Valid @RequestBody ArgumentDTO newArgument) {
        log.info("update(newArgument)");
        return argumentService.update(newArgument);
    }

    @Override
    @GetMapping("/{numberId}")
    public Optional<ArgumentDTO> findById(@PathVariable long numberId) {
        log.info("findById(numberId)");
        return argumentService.findById(numberId);
    }

    @Override
    @DeleteMapping("/{numberId}")
    public void deleteById(@PathVariable long numberId) {
        log.info("deleteById(numberId)");
        argumentService.deleteById(numberId);
    }

    @Override
    @DeleteMapping
    public void deleteAll() {
        log.info("deleteAll()");
        argumentService.deleteAll();
    }
}