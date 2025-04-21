package by.epam.number.menu;

import static by.epam.metods.console.Console.getString;
import static by.epam.number.controller.NumbersController.numberServiceImpl;

public class NumberServiceMenu extends Menu{
    @Override
    String menu() {
        System.out.println("\n\tВведите действие:" +
                "\n\t1 - вывод списка." +
                "\n\t2 - записать цифру." +
                "\n\t0 - выход из меню"
        );
        return getString();
    }

    @Override
    void select(String line) {
        switch (line){
            case "1":
                numberServiceImpl().findAll();
                break;
            case "2":
                numberServiceImpl().create();
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