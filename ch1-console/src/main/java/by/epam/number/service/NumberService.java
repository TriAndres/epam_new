package by.epam.number.service;

import by.epam.number.file.NumberFile;
import by.epam.number.model.Number;

import static by.epam.methods.Input.getInteger;

public class NumberService {
    private final NumberFile numberFile;

    public NumberService(NumberFile numberFile) {
        this.numberFile = numberFile;
    }

    public void findAll() {
        int count = 0;
        int lengthLine = 10;
        if (!numberFile.findAll().isEmpty()) {
            for (Number n : numberFile.findAll()) {
                System.out.print(n.toString() + " ");
                count++;
                if (count == lengthLine) {
                    System.out.println();
                    count = 0;
                }
            }
        } else {
            System.out.println("Заполните список.");
        }
    }

    public void create() {
        System.out.println("Введите цифру:");
        numberFile.save(new Number(getNextId(), getInteger()));
        System.out.println("Записано.");
    }

    public void update() {
        System.out.println("Ведите id цифры для обновления:");
        long idNumber = getInteger();
        if (numberFile.findAll().contains(numberFile.findById(idNumber))) {
            Number oldNumber = numberFile.findById(getInteger());
            System.out.println("Введите цифру:");
            oldNumber.setNum(getInteger());
            numberFile.save(oldNumber);
            System.out.println("Обновили.");
        } else {
            System.out.println("С таким id = " + idNumber + " не заполнен список.");
        }
    }

    public void findById() {
        System.out.println("Ведите id цифры:");
        long idNumber = getInteger();
        if (numberFile.findAll().contains(numberFile.findById(idNumber))) {
            System.out.println(numberFile.findById(idNumber));
            System.out.println("Вывод.");
        } else {
            System.out.println("С таким id = " + idNumber + " не заполнен список.");
        }
    }

    public void deleteById() {
        System.out.println("Ведите id цифры:");
        long idNumber = getInteger();
        if (numberFile.findAll().contains(numberFile.findById(idNumber))) {
            numberFile.deleteById(idNumber);
            System.out.println("Удаление.");
        } else {
            System.out.println("С таким id = " + idNumber + " не заполнен список.");
        }
    }

    public void deleteAll() {
        numberFile.deleteAll();
        System.out.println("Удалён список.");
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