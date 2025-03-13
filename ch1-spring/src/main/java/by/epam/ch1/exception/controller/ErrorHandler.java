package by.epam.ch1.exception.controller;

import by.epam.ch1.exception.*;
import by.epam.ch1.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationException.class, MethodArgumentNotValidException.class})
    public ErrorResponse handleValidationException(final ValidationException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Ошибка валидации.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handArgumentNotFond(final ArgumentDoesNotExistException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Аргумент не найден.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handEmployeeNotFond(final EmployeeDoesNotExistException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Сотрудник не найден.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handNumberNotFond(final NumberDoesNotExistException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Цифра не найдена.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handPasswordNotFond(final PasswordDoesNotExistException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Пароль не найден.");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class, InternalServerException.class})
    public ErrorResponse handleInternalServerException(final InternalServerException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Произошла непредвиденая ошибка");
    }
}