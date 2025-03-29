package by.epam.password.controller;

import by.epam.password.dto.PasswordDTO;
import by.epam.password.service.PasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/passwords")
@RequiredArgsConstructor
@Slf4j
public class PasswordControllerImpl implements PasswordService {

    private final PasswordService passwordService;

    @GetMapping
    @Override
    public Collection<PasswordDTO> passwordFindAll() {
        log.info("findAll()");
        return passwordService.passwordFindAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Override
    public PasswordDTO passwordCreate(@Valid @RequestBody PasswordDTO passwordDTO) {
        log.info("passwordCreate(passwordDTO)");
        return passwordService.passwordCreate(passwordDTO);
    }

    @PutMapping
    @Override
    public PasswordDTO passwordUpdate(@Valid @RequestBody PasswordDTO passwordDTO) {
        log.info("passwordUpdate(passwordDTO)");
        return passwordService.passwordUpdate(passwordDTO);
    }

    @GetMapping("/{id}")
    @Override
    public Optional<PasswordDTO> passwordFindById(@PathVariable long id) {
        log.info("passwordFindById(id)");
        return passwordService.passwordFindById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void passwordDeleteById(long id) {
        log.info("passwordDeleteById(id)");
        passwordService.passwordFindById(id);
    }
}
