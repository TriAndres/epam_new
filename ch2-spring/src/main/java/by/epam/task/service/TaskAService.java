package by.epam.task.service;

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
        if (!numbersRepository.findAll().isEmpty()) {
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
        } else {
            result = "Заполните список.";
        }
        return result;
    }
}