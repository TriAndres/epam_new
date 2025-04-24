package by.epam.number.service;

import by.epam.number.file.NumbersFile;
import by.epam.number.model.Numbers;

import static by.epam.metods.console.Console.getInteger;

public class NumberServiceImpl implements NumberService {
    private final NumbersFile numbersFile;

    public NumberServiceImpl(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    @Override
    public void findAll() {
        int countLine = 10;
        int count = 0;
        if (!numbersFile.findAll().isEmpty()) {
            for (Numbers num : numbersFile.findAll()) {
                System.out.print("\tid=" + num.getId() + " num=" + num.getNumbers());
                count++;
                if (count == countLine) {
                    System.out.println();
                    count = 0;
                }
            }
            System.out.println("\n\tВыведен список.");
        } else {
            System.out.println("Список надо заполнить цифрами.");
        }
    }

    @Override
    public void create() {
        System.out.println("Введите цифру:");
        numbersFile.save(new Numbers(getNextId(), getInteger()));
        System.out.println("Записано");
    }

    @Override
    public void update() {

    }

    @Override
    public void findById() {
    }

    @Override
    public void deleteById() {

    }

    @Override
    public void deleteAll() {

    }

    private long getNextId() {
        long currentMaxId = numbersFile.findAll()
                .stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}