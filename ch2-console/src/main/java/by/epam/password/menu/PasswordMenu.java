package by.epam.password.menu;

public class PasswordMenu extends Menu {
    @Override
    void menu() {
        System.out.println("\n\tВведите действие:" +
                "\n\t1 - вывод списка." +
                "\n\t2 - записать." +
                "\n\t3 - обновить." +
                "\n\t4 - удалить по id." +
                "\n\t5 - удалить весь список." +
                "\n\t0 - выйти из меню."

        );
    }

    @Override
    void select(String line) {

    }
}
