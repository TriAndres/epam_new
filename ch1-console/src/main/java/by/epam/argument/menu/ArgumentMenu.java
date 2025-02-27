package by.epam.argument.menu;

import static by.epam.argument.controller.ArgumentController.getArgumentService;
import static by.epam.methods.Input.getString;

public class ArgumentMenu {
    public void game() {
        while (true) {
            String num = menu();
            select(num);
            if (num.equals("0")) break;
        }
    }

    private String menu() {
        System.out.println("\n\tВыбирете действие:" +
                "\n\t1 - вывод списка." +
                "\n\t2 - добавление." +
                "\n\t3 - обнавление." +
                "\n\t4 - вывод по id." +
                "\n\t5 - удаление по id." +
                "\n\t6 - удалить всё." +
                "\n\t0 - Выход из меню аргумента."
        );
        return getString();
    }

    private void select(String num) {
        switch (num) {
            case "1":
                getArgumentService().findAll();
                break;
            case "2":
                getArgumentService().create();
                break;
            case "3":
                getArgumentService().update();
                break;
            case "4":
                getArgumentService().findById();
                break;
            case "5":
                getArgumentService().deleteById();
                break;
            case "6":
                getArgumentService().deleteAll();
                break;
            case "0":
                System.out.println("Выход из меню аргумента.");
                break;
            default:
                System.out.println("Выбирите действие из перечисленых.");
                break;
        }
    }
}
