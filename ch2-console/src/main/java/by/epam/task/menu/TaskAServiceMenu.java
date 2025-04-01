package by.epam.task.menu;

import static by.epam.metods.console.Console.getString;
import static by.epam.task.controller.TackController.taskAService;

public class TaskAServiceMenu extends Menu {
    @Override
    String menu() {
        System.out.println("\n\tВведите действие:" +
                "\n\t1 - 1 задача." +
                "\n\t0 - выход из меню"
        );
        return getString();
    }

    @Override
    void select(String line) {
        switch (line) {
            case "1":
                taskAService().taskA1();
                break;
            case "0":
                System.out.println("Выход из меню.");
                break;
            default:
                System.out.println("Введите предложеные действия.");
                break;
        }
    }
}
