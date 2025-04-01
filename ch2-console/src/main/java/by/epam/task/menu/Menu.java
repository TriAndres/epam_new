package by.epam.task.menu;

public abstract class Menu {
    public void game() {
        while (true) {
            String line = menu();
            select(line);
            if (line.equals("0")) break;
        }
    }
    abstract String menu();
    abstract void select(String line);
}
