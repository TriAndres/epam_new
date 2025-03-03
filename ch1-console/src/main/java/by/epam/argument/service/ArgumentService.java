package by.epam.argument.service;

import by.epam.argument.file.ArgumentFile;
import by.epam.argument.model.Argument;

import static by.epam.argument.file.ArgumentFile.loadFromFile;
import static by.epam.methods.Input.getInteger;
import static by.epam.methods.Input.getString;

public class ArgumentService {
    private final ArgumentFile argumentFile;

    public ArgumentService(ArgumentFile argumentFile) {
        this.argumentFile = argumentFile;
    }

    public static void main(String[] args) {
        String file = "ch1A\\src\\main\\java\\by\\epam\\argument\\file\\ArgumentFile.txt";
        ArgumentFile argumentFile = loadFromFile(file);
        new ArgumentService(argumentFile).create();
    }
    public void findAll() {
        int count = 0;
        int lengthLine = 10;
        if (!argumentFile.findAll().isEmpty()) {
            for (Argument a : argumentFile.findAll()) {
                System.out.print(a.toString() + " ");
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
        System.out.println("Введите аргумент:");
        argumentFile.save(new Argument(getNextId(), getString()));
        System.out.println("Записано.");
    }

    public void update() {
        System.out.println("Ведите id аргумента для обновления:");
        long idArgument = getInteger();
        if (argumentFile.findAll().contains(argumentFile.findById(idArgument))) {
            Argument oldArgument = argumentFile.findById(idArgument);
            System.out.println("Введите аргумент:");
            oldArgument.setArgument(getString());
            argumentFile.save(oldArgument);
            System.out.println("Обновили.");
        } else {
            System.out.println("С таким id = " + idArgument + " не заполнен список.");
        }
    }

    public void findById() {
        System.out.println("Введите id аргумента:");
        long idArgument = getInteger();
        if (argumentFile.findAll().contains(argumentFile.findById(idArgument))) {
            System.out.println(argumentFile.findById(idArgument));
            System.out.println("Вывод.");
        } else {
            System.out.println("С таким id = " + idArgument + " не заполнен список.");
        }
    }

    public void deleteById() {
        System.out.println("Введите id аргумента:");
        long idArgument = getInteger();
        if (argumentFile.findAll().contains(argumentFile.findById(idArgument))) {
            argumentFile.deleteById(idArgument);
            System.out.println("Удаление.");
        } else {
            System.out.println("С таким id = " + idArgument + " не заполнен список.");
        }
    }

    public void deleteAll() {
        argumentFile.deleteAll();
        System.out.println("Удалён список.");
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