package by.epam;

import by.epam.number.menu.NumberServiceMenu;
import by.epam.number.menu.TaskBServiceMenu;
import by.epam.password.menu.PasswordMenu;
import by.epam.number.menu.TaskAServiceMenu;

import static by.epam.metods.console.Console.getString;

public class Main {
    public static void main(String[] args) {
        new Main().game();
    }

    public void game() {
        while (true) {
            String line = menu();
            select(line);
            if (line.equals("0")) break;
        }
    }
    private String menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - меню пароля." +
                "\n\t2 - меню цифр." +
                "\n\t3 - меню задачА." +
                "\n\t4 - меню задачВ." +
                "\n\t0 - выход из программы"
        );
        return getString();
    }

    private void select(String line) {
        switch (line){
            case "1":
                new PasswordMenu().game();
                break;
            case "2":
                new NumberServiceMenu().game();
                break;
            case "3":
                new TaskAServiceMenu().game();
                break;
            case "4":
                new TaskBServiceMenu().game();
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