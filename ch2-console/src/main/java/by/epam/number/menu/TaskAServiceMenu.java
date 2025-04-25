package by.epam.number.menu;

import static by.epam.metods.console.Console.getString;
import static by.epam.number.controller.NumbersController.taskAService;


public class TaskAServiceMenu extends Menu {
    @Override
    String menu() {
        System.out.println("\n\tВведите действие:" +
                "\n\t1 - 1 задача." +
                "\n\t2 - 2 задача." +
                "\n\t3 - 3 задача." +
                "\n\t4 - 4 задача." +
                "\n\t5 - 5 задача." +
                "\n\t6 - 6 задача." +
                "\n\t7 - 7 задача." +
                "\n\t8 - 8 задача." +
                "\n\t9 - 9 задача." +
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
            case "2":
                taskAService().taskA2();
                break;
            case "3":
                taskAService().taskA3();
                break;
            case "4":
                taskAService().taskA4();
                break;
            case "5":
                taskAService().taskA5();
                break;
            case "6":
                taskAService().taskA6();
                break;
            case "7":
                taskAService().taskA7();
                break;
            case "8":
                taskAService().taskA8();
                break;
            case "9":
                taskAService().taskA9();
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
