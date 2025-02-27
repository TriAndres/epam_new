package by.epam.number.menu;

import static by.epam.methods.Input.getString;
import static by.epam.number.controller.NumberController.numberService;

public class NumberMenu {
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
                "\n\t0 - Выход из меню цифр."
        );
        return getString();
    }

    private void select(String num) {
        switch (num) {
            case "1":
                numberService().findAll();
                break;
            case "2":
                numberService().create();
                break;
            case "3":
                numberService().update();
                break;
            case "4":
                numberService().findById();
                break;
            case "5":
                numberService().deleteById();
                break;
            case "6":
                numberService().deleteAll();
                break;
            case "0":
                System.out.println("Выход из меню цифр.");
                break;
            default:
                System.out.println("Выбирите действие из перечисленых.");
                break;
        }
    }
}