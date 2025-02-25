package by.epam.argument.servise;

import by.epam.argument.file.ArgumentFile;
import by.epam.argument.model.Argument;

import static by.epam.methods.console.Input.getString;

public class ArgumentService {
    private final ArgumentFile argumentFile;
    private Integer task;

    public ArgumentService(ArgumentFile argumentFile) {
        this.argumentFile = argumentFile;
    }

    public void task1() {
        task = 1;
        System.out.println("Введите ваше имя:");
        String name = getString();
        System.out.println(new Argument(getNextId(), task, name).getArgument() + ", Вас приветствую!");
    }

    private long getNextId() {
        long currentMaxId = argumentFile
                .findAll()
                .stream()
                .mapToLong(Argument::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
