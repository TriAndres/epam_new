package by.epam.task.service;

import by.epam.exception.NumbersDoesNotExistException;
import by.epam.number.model.Numbers;
import by.epam.number.repository.NumbersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskAService {
    private final NumbersRepository numbersRepository;

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

    /*
    public void taskA2() {
        String result;
        int lineSize = 10;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.\n";
            result += "В порядке возрастания значений:\n";
            result += show(numbersFile.findAll().stream().sorted((a, b) -> a.getNum() - b.getNum()).toList(), result, lineSize);

            result += "\nВ порядке убывания значений:\n";
            result += show(numbersFile.findAll().stream().sorted((a, b) -> b.getNum() - a.getNum()).toList(), result, lineSize);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String show(List<Numbers> list, String result, int lineSize) {
        int count = 0;
        result = "Вывод: number/length\n";
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
     */
}