package by.epam;


import static by.epam.argument.controller.ArgumentController.getArgumentService;
import static by.epam.methods.console.Input.getString;

public class Main {
    public static void main(String[] args) {
        new Main().game();
    }

    public void game() {
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
                "\n\t2 - задача N3" +
                "\n\t2 - задача N4" +
                "\n\t2 - задача N5" +
                "\n\t2 - задача N6" +
                "\n\t0 - Выход из программы."
        );
        return getString();
    }

    private void select(String num) {
        switch (num) {
            case "1":
                getArgumentService().task1();
                break;
            case "0":
                System.out.println("Выход из программы.");
                break;
            default:
                System.out.println("Выбирите действие из перечисленых.");
                break;
        }
    }
}