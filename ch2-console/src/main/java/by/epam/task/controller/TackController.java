package by.epam.task.controller;

import by.epam.number.file.NumbersFile;
import by.epam.task.service.TaskAService;

import static by.epam.number.file.NumbersFile.loadFromFile;

public class TackController {
    private static final String file = "ch2-console\\src\\main\\java\\by\\epam\\number\\file\\NumbersFile.txt";
    private static final NumbersFile numbersFile = loadFromFile(file);

    public static TaskAService taskAService() {
        return new TaskAService(numbersFile);
    }
}
