package by.epam.password.controller;

import by.epam.password.dto.PasswordDTO;
import by.epam.password.service.PasswordServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passwords")
@RequiredArgsConstructor
@Slf4j
public class PasswordControllerImpl implements PasswordController {
    private final PasswordServiceImpl passwordService;

    @GetMapping
    @Override
    public Collection<PasswordDTO> findAll() {
        log.info("findAll()");
        return passwordService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public PasswordDTO passwordCreate(@Valid @RequestBody PasswordDTO passwordDTO) {
        log.info("passwordCreate(passwordDTO)");
        return passwordService.passwordCreate(passwordDTO);
    }

    @Override
    public PasswordDTO passwordUpdate(long id, PasswordDTO passwordDTO) {
        return null;
    }

    @PutMapping
    @Override
    public PasswordDTO passwordUpdate2(@Valid @RequestBody PasswordDTO passwordDTO) {
        log.info("passwordUpdate2(passwordDTO)");
        return passwordService.passwordCreate(passwordDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public Optional<PasswordDTO> passwordFindById(@PathVariable long id) {
        log.info("passwordFindById(id)");
        return passwordService.passwordFindById(id);
    }

    @Override
    public void passwordDeleteId(long id) {
        log.info("passwordDeleteAll(id)");
        passwordService.passwordFindById(id);
    }
}