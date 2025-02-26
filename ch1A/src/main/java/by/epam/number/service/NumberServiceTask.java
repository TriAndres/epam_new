package by.epam.number.service;

import by.epam.number.file.NumberFile;
import by.epam.number.model.Number;

public class NumberServiceTask {
    private final NumberFile numberFile;

    public NumberServiceTask(NumberFile numberFile) {
        this.numberFile = numberFile;
    }

    public void task3() {
        System.out.println("3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.");
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
