package by.epam.metods.console;

import java.util.Scanner;

public class Console {
    public static final Scanner scanner = new Scanner(System.in);

    public static Integer getInteger() {
        int a = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                a = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return a;
    }

    public static String getString() {
        return scanner.next();
    }
}
