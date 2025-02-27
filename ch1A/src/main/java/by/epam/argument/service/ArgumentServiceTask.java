package by.epam.argument.service;

import by.epam.argument.file.ArgumentFile;
import by.epam.argument.model.Argument;

import static by.epam.methods.Input.getString;

public class ArgumentServiceTask {
    private final ArgumentFile argumentFile;

    public ArgumentServiceTask(ArgumentFile argumentFile) {
        this.argumentFile = argumentFile;
    }

    public void task1() {
        System.out.println("1. Приветствовать любого пользователя при вводе его имени через командную строку");
        System.out.println("Введите ваше имя:");
        String name = getString();
        System.out.println(name + ", Вас приветствую!");
        argumentFile.save(new Argument(getNextId(), name));
    }

    public void task2() {
        System.out.println("2. Отобразить в окне консоли аргументы командной строки в обратном порядке.");
        System.out.println("\tВведите аргумент:");
        String argument = getString();
        String s = new StringBuilder().append(argument).reverse().toString();
        System.out.println("\tВ обратном порядке:\n\t"+ s);
        argumentFile.save(new Argument(getNextId(), argument));
    }

    public void task4() {
        System.out.println("4. Ввести пароль из командной строки и сравнить его со строкой-образцом.");
        String model = "passwordSuper";
        System.out.println("\tВведите правильно образец пароля" + model + ":");
        String password = getString();
        if (model.equals(password)) {
            System.out.println("Ввели верно.");
        } else {
            System.out.println("Ввели не верно.");
        }
        argumentFile.save(new Argument(getNextId(), password));
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