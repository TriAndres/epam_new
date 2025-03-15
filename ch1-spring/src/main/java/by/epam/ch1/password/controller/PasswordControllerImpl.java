package by.epam.ch1.password.controller;

import by.epam.ch1.exception.ParameterNotValidException;
import by.epam.ch1.password.dto.PasswordDTO;
import by.epam.ch1.password.model.SortOrderP;
import by.epam.ch1.password.service.PasswordServiceImpl;
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
@RequestMapping("/password")
@Slf4j
public class PasswordControllerImpl implements PasswordController {
    private final PasswordServiceImpl passwordService;

    @Override
    @GetMapping
    public Collection<PasswordDTO> findAll(@RequestParam(defaultValue = "desc") String sort,
                                           @RequestParam(defaultValue = "0") int from,
                                           @RequestParam(defaultValue = "10") int size) {
        SortOrderP sortOrderP = SortOrderP.from(sort);
        if (sortOrderP == null) {
            throw new ParameterNotValidException("sort", "Получено: " + sort + " должно быть: ask или desc");
        }
        if (size <= 0) {
            throw new ParameterNotValidException("size", "Размер должен быть больше нуля");
        }

        if (from < 0) {
            throw new ParameterNotValidException("from", "Начало выборки должно быть положительным числом");
        }
        return passwordService.findAll(Objects.requireNonNull(SortOrderP.from(sort)), from, size);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PasswordDTO create(@Valid @RequestBody PasswordDTO password) {
        return passwordService.create(password);
    }

    @Override
    @PutMapping
    public PasswordDTO update(@Valid @RequestBody PasswordDTO newPassword) {
        return passwordService.update(newPassword);
    }

    @Override
    @GetMapping("/{passwordId}")
    public Optional<PasswordDTO> findById(@PathVariable long passwordId) {
        return passwordService.findById(passwordId);
    }

    @Override
    @DeleteMapping("/{passwordId}")
    public void deleteById(@PathVariable long passwordId) {
        passwordService.deleteById(passwordId);
    }

    @Override
    @DeleteMapping()
    public void deleteAll() {
        passwordService.deleteAll();
    }
}