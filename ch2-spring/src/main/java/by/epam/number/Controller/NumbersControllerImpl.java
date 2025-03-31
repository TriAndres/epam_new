package by.epam.number.Controller;

import by.epam.number.dto.NumbersDTO;
import by.epam.number.service.NumbersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/numbers")
@RequiredArgsConstructor
@Slf4j
public class NumbersControllerImpl implements NumbersController {
    private final NumbersService numbersService;

    @Override
    @GetMapping
    public Collection<NumbersDTO> numbersFindAll() {
        log.info("numbersFindAll()");
        return numbersService.numbersFindAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NumbersDTO numbersCreate(@Valid @RequestBody NumbersDTO numbersDTO) {
        log.info("numbersCreate(NumbersDTO numbersDTO)");
        return numbersService.numbersCreate(numbersDTO);
    }

    @Override
    @PutMapping
    public NumbersDTO numbersUpdate(@Valid @RequestBody NumbersDTO newNumbersDTO) {
        log.info("numbersUpdate(NumbersDTO newNumbersDTO)");
        return numbersService.numbersUpdate(newNumbersDTO);
    }

    @Override
    @GetMapping("/{id}")
    public Optional<NumbersDTO> numbersFindById(@PathVariable long id) {
        log.info("numbersFindById(id)");
        return numbersService.numbersFindById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void numbersDeleteById(@PathVariable long id) {
        log.info("numbersDeleteById(id)");
        numbersService.numbersDeleteById(id);
    }
}
