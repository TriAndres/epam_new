package by.epam.number.service;

import by.epam.number.dto.NumbersDTO;
import by.epam.number.exception.NumbersDoesNotExistException;
import by.epam.number.model.Numbers;
import by.epam.number.repository.NumbersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
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

    public String taskA1() {
        String result;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            List<Numbers> list = numbersRepository.findAll()
                    .stream()
                    .sorted((a, b) -> a.getNum() - b.getNum())
                    .toList();

            result = "1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.\n";

            int min = list.getFirst().getNum();
            int minLength = String.valueOf(min).length();
            result += "min=" + min + " length=" + minLength + "\n";

            int max = list.getLast().getNum();
            int maxLength = String.valueOf(max).length();
            result += "max=" + max + " lemgth=" + maxLength + "\n";

            log.info("Вывод задачи taskA1()");

            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    public String taskA2() {
        String result;
        int lineSize = 10;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            result = "2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.\n";
            result += "В порядке возрастания значений:\n";
            result += show(numbersRepository.findAll().stream().sorted((a, b) -> a.getNum() - b.getNum()).toList(), result, lineSize);

            result += "\nВ порядке убывания значений:\n";
            result += show(numbersRepository.findAll().stream().sorted((a, b) -> b.getNum() - a.getNum()).toList(), result, lineSize);

            log.info("Вывод задачи taskA1()");

            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    private String show(List<Numbers> list, String result, int lineSize) {
        int count = 0;
        result += "Вывод: number/length\n";
        for (Numbers numbers : list) {
            result += "\t" + numbers.getNum() + "/" + String.valueOf(numbers.getNum()).length();
            count++;
            if (count == lineSize) {
                result +="\n";
                count = 0;
            }
        }
        return result;
    }

    public String taskA3() {
        String result;
        int lineSize = 10;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            result = "3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.\n";
            int sum = numbersRepository.findAll().stream().mapToInt(Numbers::getNum).sum();
            result += "Числа меньше средней:\n";
            result += show(numbersRepository.findAll()
                            .stream()
                            .filter(i -> i.getNum() > sum / numbersRepository.findAll().size())
                            .toList()
                    , result, lineSize);
            result += "\nЧисла больше средней:\n";
            result += show(numbersRepository.findAll()
                            .stream()
                            .filter(i -> i.getNum() < sum / numbersRepository.findAll().size())
                            .toList()
                    , result, lineSize);
            return result;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }
}