package by.epam.ch1.argument.controller;

import by.epam.ch1.argument.Service.ArgumentServiceImpl;
import by.epam.ch1.argument.model.Argument;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/argument")
@Slf4j
public class ArgumentControllerImpl implements ArgumentController {
    private final ArgumentServiceImpl argumentService;

    @Override
    @GetMapping
    public Collection<Argument> findAll() {
        return argumentService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Argument create(@Valid @RequestBody Argument argument) {
        return argumentService.create(argument);
    }

    @Override
    @PutMapping
    public Argument update(@Valid @RequestBody Argument newArgument) {
        return argumentService.update(newArgument);
    }

    @Override
    @GetMapping("/{numberId}")
    public Optional<Argument> findById(@PathVariable long numberId) {
        return argumentService.findById(numberId);
    }

    @Override
    @DeleteMapping("/{numberId}")
    public void deleteById(@PathVariable long numberId) {
        argumentService.deleteById(numberId);
    }

    @Override
    @DeleteMapping
    public void deleteAll() {
        argumentService.deleteAll();
    }
}