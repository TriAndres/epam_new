package by.epam.password.menu;

import static by.epam.metods.console.Console.getString;

public abstract class Menu {
    public void game() {
        while (true) {
            menu();
            String line = getString();
            select(line);
            if (line.equals("0")) break;
        }
    }
    abstract void menu();
    abstract void select(String line);
}