package by.epam.number.menu;

import static by.epam.methods.Input.getString;
import static by.epam.number.controller.NumberController.numberService;
import static by.epam.number.controller.NumberController.numberServiceTaskB;

public class NumberTaskBMenu {
    public void game() {
        while (true) {
            String num = menu();
            select(num);
            if (num.equals("0")) break;
        }
    }

    private String menu() {
        System.out.println("\n\t Вариант В" +
                "\n\tВыбирете действие:" +
                "\n\t1 - задача N1." +
                "\n\t2 - задача N2." +
                "\n\t3 - задача N3." +
                "\n\t4 - задача N4." +
                "\n\t5 - задача N5." +
                "\n\t6 - задача N6." +
                "\n\t7 - задача N7." +
                "\n\t8 - задача N8." +
                "\n\t9 - задача N9." +
                "\n\t10 - задача N10." +
                "\n\t11 - задача N11." +
                "\n\t0 - Выход из меню цифр."
        );
        return getString();
    }

    private void select(String num) {
        switch (num) {
            case "1":
                numberServiceTaskB().taskB1();
                break;
            case "2":
                numberServiceTaskB().taskB2();
                break;
            case "3":
                numberServiceTaskB().taskB3();
                break;
            case "4":
                numberServiceTaskB().taskB4();
                break;
            case "5":
                numberServiceTaskB().taskB5();
                break;
            case "6":
                numberServiceTaskB().taskB6();
                break;
            case "7":
                numberServiceTaskB().taskB7();
                break;
            case "8":
                numberServiceTaskB().taskB8();
                break;
            case "9":
                numberServiceTaskB().taskB9();
                break;
            case "10":
                numberServiceTaskB().taskB10();
                break;
            case "11":
                numberServiceTaskB().taskB11();
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
