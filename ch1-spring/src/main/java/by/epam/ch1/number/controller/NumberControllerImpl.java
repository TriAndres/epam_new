package by.epam.ch1.number.controller;

import by.epam.ch1.exception.ParameterNotValidException;
import by.epam.ch1.number.model.Number;
import by.epam.ch1.number.model.SortOrderN;
import by.epam.ch1.number.service.NumberServiceImpl;
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
@RequestMapping("/number")
@Slf4j
public class NumberControllerImpl implements NumberController {
    private final NumberServiceImpl numberService;

    @Override
    @GetMapping
    public Collection<Number> findAll(@RequestParam(defaultValue = "desk") String sort,
                                      @RequestParam(defaultValue = "0") int from,
                                      @RequestParam(defaultValue = "10") int size) {
        SortOrderN sortOrderN = SortOrderN.from(sort);
        if (sortOrderN == null) {
            throw new ParameterNotValidException("sort", "Получено: " + sort + " должно быть: ask или desc");
        }
        if (size <= 0) {
            throw new ParameterNotValidException("size", "Размер должен быть больше нуля");
        }

        if (from < 0) {
            throw new ParameterNotValidException("from", "Начало выборки должно быть положительным числом");
        }
        return numberService.findAll(Objects.requireNonNull(SortOrderN.from(sort)), from, size);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Number create(@Valid @RequestBody Number number) {
        return numberService.create(number);
    }

    @Override
    @PutMapping
    public Number update(@Valid @RequestBody Number number) {
        return numberService.update(number);
    }

    @Override
    @GetMapping("/{numberId}")
    public Optional<Number> findById(@PathVariable long numberId) {
        return numberService.findById(numberId);
    }

    @Override
    @DeleteMapping("/{numberId}")
    public void deleteById(@PathVariable long numberId) {
        numberService.deleteById(numberId);
    }

    @Override
    @DeleteMapping
    public void deleteAll() {
        numberService.deleteAll();
    }
}