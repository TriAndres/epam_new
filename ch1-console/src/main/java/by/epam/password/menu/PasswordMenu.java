package by.epam.password.menu;

import static by.epam.methods.Input.getString;
import static by.epam.password.controller.PasswordController.passwordServiceEntrance;
import static by.epam.password.controller.PasswordController.passwordServiceRegistration;

public class PasswordMenu {

    public void game() {
        while (true) {
            String num = menu();
            select(num);
            break;
        }
    }

    private String menu() {
        System.out.println("\n\tВыбирете действие:" +
                "\n\t1 - регистрация." +
                "\n\t2 - вход"
        );
        return getString();
    }

    private void select(String num) {
        switch (num) {
            case "1":
                passwordServiceRegistration().registration();
                break;
            case "2":
                passwordServiceEntrance().entrance();
                break;
            default:
                System.out.println("Выбирите действие из перечисленых.");
                break;
        }
    }

    public boolean enterBool() {
        if (passwordServiceRegistration().registrationBool() || passwordServiceEntrance().registrationBool()) {
            return true;
        }
        return false;
    }
}
