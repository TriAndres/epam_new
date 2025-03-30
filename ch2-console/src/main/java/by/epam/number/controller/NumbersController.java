package by.epam.number.controller;

import by.epam.number.file.NumbersFile;
import by.epam.number.service.NumberServiceImpl;

import static by.epam.number.file.NumbersFile.loadFromFile;

public class NumbersController {
    private static final String file = "ch2-console\\src\\main\\java\\by\\epam\\number\\file\\NumbersFile.txt";
    private static final NumbersFile numbersFile = loadFromFile(file);

    public static NumberServiceImpl numberServiceImpl() {
        return new NumberServiceImpl(numbersFile);
    }
}
