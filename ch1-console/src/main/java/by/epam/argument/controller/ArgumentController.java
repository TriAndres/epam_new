package by.epam.argument.controller;

import by.epam.argument.file.ArgumentFile;
import by.epam.argument.service.ArgumentService;
import by.epam.argument.service.ArgumentServiceTask;

import static by.epam.argument.file.ArgumentFile.loadFromFile;

public class ArgumentController {
    private static final String file = "ch1A\\src\\main\\java\\by\\epam\\argument\\file\\ArgumentFile.txt";
    private static final ArgumentFile argumentFile = loadFromFile(file);

    public static ArgumentService getArgumentService() {
        return new ArgumentService(argumentFile);
    }

    public static ArgumentServiceTask getArgumentServiceTask() {
        return new ArgumentServiceTask(argumentFile);
    }
}