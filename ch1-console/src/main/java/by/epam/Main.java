package by.epam;


import by.epam.argument.menu.ArgumentMenu;
import by.epam.number.menu.NumberMenu;
import by.epam.password.menu.PasswordMenu;

import static by.epam.argument.controller.ArgumentController.getArgumentServiceTask;
import static by.epam.methods.Input.getString;
import static by.epam.number.controller.NumberController.numberServiceTaskA;
import static by.epam.password.controller.PasswordController.passwordServiceTask6;

public class Main {
    public static void main(String[] args) {
        new Main().game();
    }

    public void game() {

        while (true) {
            PasswordMenu passwordMenu = new PasswordMenu();
            passwordMenu.game();
            if (passwordMenu.enterBool()) {
                passwordServiceTask6().task();
                System.out.println("\n\tВыбирете действие:" +
                        "\n\t1 - меню аргумента." +
                        "\n\t2 - меню цифр." +
                        "\n\t3 - меню задач." +
                        "\n\t0 - Выход из программы."
                );
                String num = getString();
                switch (num) {
                    case "1":
                        new ArgumentMenu().game();
                        break;
                    case "2":
                        new NumberMenu().game();
                        break;
                    case "3":
                        menuTask();
                        break;
                    case "0":
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Выбирите действие из перечисленых.");
                        break;
                }
                if (num.equals("0")) break;
            }
        }

    }

    private void menuTask() {
        while (true) {
            String num = menu();
            select(num);
            if (num.equals("0")) break;
        }
    }

    private String menu() {
        System.out.println("\n\tВыбирете действие:" +
                "\n\t1 - задача N1" +
                "\n\t2 - задача N2" +
                "\n\t3 - задача N3" +
                "\n\t4 - задача N4" +
                "\n\t5 - задача N5" +
                "\n\t6 - задача N6" +
                "\n\t0 - Выход из меню задач."
        );
        return getString();
    }

    private void select(String num) {
        switch (num) {
            case "1":
                getArgumentServiceTask().task1();
                break;
            case "2":
                getArgumentServiceTask().task2();
                break;
            case "3":
                numberServiceTaskA().task3();
                break;
            case "4":
                getArgumentServiceTask().task4();
                break;
            case "5":
                numberServiceTaskA().task5();
                break;
            case "6":
                System.out.println("В разработке.");
                break;
            case "0":
                System.out.println("Выход из меню задач.");
                break;
            default:
                System.out.println("Выбирите действие из перечисленых.");
                break;
        }
    }
}