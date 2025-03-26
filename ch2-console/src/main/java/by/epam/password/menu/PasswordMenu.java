package by.epam.password.menu;

import static by.epam.password.controller.PasswordController.getPasswordServiceImpl;

public class PasswordMenu extends Menu {
    @Override
    void menu() {
        System.out.println("\n\tВведите действие:" +
                "\n\t1 - вывод списка." +
                "\n\t2 - записать." +
                "\n\t3 - обновить." +
                "\n\t4 - вывод по id." +
                "\n\t5 - удалить по id." +
                "\n\t0 - выйти из меню."

        );
    }

    @Override
    void select(String line) {
        switch (line) {
            case "1":
                getPasswordServiceImpl().findAll();
                break;
            case "2":
                getPasswordServiceImpl().create();
                break;
            case "3":
                getPasswordServiceImpl().update();
                break;
            case "4":
                getPasswordServiceImpl().findById();
                break;
            case "5":
                getPasswordServiceImpl().deleteById();
                break;
            case "0":
                System.out.println("Выход из меню.");
                break;
            default:
                System.out.println("Выбирите другое действие.");
                break;
        }
    }
}
