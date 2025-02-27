package by.epam.methods;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.next();
    }

    public static int getInteger() {
        int n;
        while (true) {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return n;
    }
}