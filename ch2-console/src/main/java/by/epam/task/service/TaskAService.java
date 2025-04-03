package by.epam.task.service;

import by.epam.number.file.NumbersFile;
import by.epam.number.model.Numbers;


import java.util.List;

public class TaskAService extends Task{

    public TaskAService(NumbersFile numbersFile) {
        super(numbersFile);
    }

    public void taskA1() {
        String result;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            List<Numbers> list = numbersFile.findAll()
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
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
}