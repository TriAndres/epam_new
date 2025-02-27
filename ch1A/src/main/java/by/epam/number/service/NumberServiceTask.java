package by.epam.number.service;

import by.epam.number.file.NumberFile;
import by.epam.number.model.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static by.epam.methods.Input.getInteger;

public class NumberServiceTask {
    private final NumberFile numberFile;

    public NumberServiceTask(NumberFile numberFile) {
        this.numberFile = numberFile;
    }

    public void task3() {
        System.out.println("3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.");
        System.out.println("Введите количество чисел:");
        int lengthNum = getInteger();
        System.out.println("Введите диапазон чисел ОТ:");
        int from = getInteger();
        System.out.println("Введите диапвзон чисел ДО:");
        int to;
        while (true) {
            to = getInteger();
            if (to > from) {
                break;
            } else {
                System.out.println("Введите цифру большеи ОТ");
            }
        }
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lengthNum; i++) {
            list.add(from + random.nextInt(to - from));
        }
        System.out.println("Введите количество чисел в строке:");
        int count = 0;
        int lengthLine = getInteger();
        System.out.println("Вывод чисел с переходом:");
        for (Integer i : list) {
            System.out.printf("%d\t", i);
            count++;
            if (count == lengthLine) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println("\nВывод чисел без переходом:");
        for (Integer i : list) {
            System.out.printf("%d\t", i);
        }
    }

    public void task5() {
        System.out.println("5. Ввести целые числа как аргументы командной строки, подсчитать их суммы и произведения." +
                " Вывести результат на консоль.");
    }

    private long getNextId() {
        long currentMaxId = numberFile
                .findAll()
                .stream()
                .mapToLong(Number::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
