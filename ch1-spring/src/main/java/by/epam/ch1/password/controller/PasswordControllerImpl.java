package by.epam.ch1.password.controller;

import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.service.PasswordServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/password")
@Slf4j
public class PasswordControllerImpl implements PasswordController {
    private final PasswordServiceImpl passwordService;

    @Override
    @GetMapping
    public Collection<Password> findAll() {
        return passwordService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Password create(@Valid @RequestBody Password password) {
        return passwordService.create(password);
    }

    @Override
    @PutMapping
    public Password update(@Valid @RequestBody Password newPassword) {
        return passwordService.update(newPassword);
    }

    @Override
    @GetMapping("/{passwordId}")
    public Optional<Password> findById(@PathVariable long passwordId) {
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