package by.epam.ch1.password.controller;

import by.epam.ch1.password.model.Password;
import by.epam.ch1.password.service.PasswordService;
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
public class PasswordController {
    private final PasswordService passwordService;

    @GetMapping
    public Collection<Password> findAll() {
        return passwordService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Password create(@Valid @RequestBody Password password) {
        return passwordService.create(password);
    }

    @PutMapping
    public Password update(@Valid @RequestBody Password newPassword) {
        return passwordService.update(newPassword);
    }

    @GetMapping("/{passwordId}")
    public Optional<Password> findById(@PathVariable long passwordId) {
        return passwordService.findById(passwordId);
    }

    @DeleteMapping("/{passwordId}")
    public void deleteById(@PathVariable long passwordId) {
        passwordService.deleteById(passwordId);
    }

    @DeleteMapping()
    public void deleteAll() {
        passwordService.deleteAll();
    }
}