package by.epam.number.controller;

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
public class NumbersControllerImpl implements NumbersController, NumbersTaskController {
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

    @Override
    @GetMapping("/task1")
    public String taskA1() {
        return numbersService.taskA1();
    }

    @Override
    @GetMapping("/task2")
    public String taskA2() {
        return numbersService.taskA2();
    }

    @Override
    @GetMapping("/task3")
    public String taskA3() {
        return numbersService.taskA3();
    }

    @Override
    @GetMapping("/task4")
    public String taskA4() {
        return numbersService.taskA4();
    }

    @Override
    @GetMapping("/task5")
    public String taskA5() {
        return "";
    }

    @Override
    @GetMapping("/task6")
    public String taskA6() {
        return "";
    }

    @Override
    @GetMapping("/task7")
    public String taskA7() {
        return "";
    }

    @Override
    @GetMapping("/task8")
    public String taskA8() {
        return "";
    }

    @Override
    @GetMapping("/task9")
    public String taskA9() {
        return "";
    }
}