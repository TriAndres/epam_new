package by.epam.number.service;

import by.epam.exception.NumbersDoesNotExistException;
import by.epam.number.dto.NumbersDTO;
import by.epam.number.model.Numbers;
import by.epam.number.repository.NumbersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static by.epam.number.mapper.NumbersMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumbersServiceImpl implements NumbersService {

    private final NumbersRepository numbersRepository;

    @Override
    public Collection<NumbersDTO> numbersFindAll() {
        return toListDTO(numbersRepository.findAll());
    }

    @Override
    public NumbersDTO numbersCreate(NumbersDTO numbersDTO) {
        Numbers numbers = toModel(numbersDTO);
        return toDTO(numbersRepository.save(numbers));
    }

    @Override
    public NumbersDTO numbersUpdate(NumbersDTO newNumbersDTO) {
        try {
            Numbers oldNumbers = numbersRepository
                    .findById(newNumbersDTO.getId())
                    .orElseThrow();
            oldNumbers.setNum(newNumbersDTO.getNum());
            numbersRepository.save(oldNumbers);
            return toDTO(oldNumbers);
        } catch (RuntimeException e) {
            throw new NumbersDoesNotExistException("Введите правильно:id, цифру");
        }
    }

    @Override
    public Optional<NumbersDTO> numbersFindById(long id) {
        return Optional.of(toDTO(numbersRepository
                .findById(id)
                .orElseThrow(() -> new NumbersDoesNotExistException("Цифра не найдена."))));
    }

    @Override
    public void numbersDeleteById(long id) {
        numbersRepository.deleteById(id);
    }
}