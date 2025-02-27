package by.epam.number.controller;

import by.epam.number.file.NumberFile;
import by.epam.number.service.NumberService;
import by.epam.number.service.NumberServiceTask;

import static by.epam.number.file.NumberFile.loadFromFile;

public class NumberController {
    private static final String file = "ch1A\\src\\main\\java\\by\\epam\\number\\file\\NumberFile.txt";
    private static final NumberFile numberFile = loadFromFile(file);

    public static NumberService numberService() {
        return new NumberService(numberFile);
    }

    public static NumberServiceTask numberServiceTask() {
        return new NumberServiceTask(numberFile);
    }
}
