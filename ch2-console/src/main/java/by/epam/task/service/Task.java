package by.epam.task.service;

import by.epam.number.file.NumbersFile;

public abstract class Task {
    protected final NumbersFile numbersFile;

    protected Task(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }
}
